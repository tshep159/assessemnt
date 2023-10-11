package za.co.momentum.investment.app.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import za.co.momentum.investment.app.controller.ClientController;
import za.co.momentum.investment.app.entity.Client;
import za.co.momentum.investment.app.entity.ClientProductItem;
import za.co.momentum.investment.app.entity.Product;
import za.co.momentum.investment.app.entity.WithdrawalProcess;
import za.co.momentum.investment.app.service.ClientProductItemService;
import za.co.momentum.investment.app.service.ClientService;
import za.co.momentum.investment.app.service.ProductService;
import za.co.momentum.investment.app.service.WithdrawalProcessService;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RequestMapping("/api/client")
@RestController
public class ClientControllerImpl  implements ClientController {

    private static final Logger logger = Logger.getLogger(String.valueOf(ClientControllerImpl.class));
    private final ClientService service;
    private final ProductService productDAO;
    private final ClientProductItemService clientProductItemService;
    private final WithdrawalProcessService withDrawalDAO;

    public ClientControllerImpl(ClientService service, ProductService productDAO, ClientProductItemService clientProductItemService, WithdrawalProcessService withDrawalDAO) {
        this.service = service;
        this.productDAO = productDAO;
        this.clientProductItemService = clientProductItemService;
        this.withDrawalDAO = withDrawalDAO;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client clientDTO) {
        return service.save(clientDTO);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/{id}", method = RequestMethod.GET)
//getting product by product id
    public Client findByOneId(@PathVariable("id") Long id) {

        Client client = service.findById(id).orElse(null);
        return client;
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/{id}/products", method = RequestMethod.GET)
//getting product for client
    public List<ClientProductItem> findClientProductsById(@PathVariable("id") Long id) {
        return clientProductItemService.findClientProductById(id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }//delete client details

    @Override
    @GetMapping
    public List<Client> list() {
        List<Client> clients = service.findAll();//getting all clinetns
        return clients;
    }

    @Override
    @GetMapping("/page-query")
    public Page<Client> pageQuery(Pageable pageable) {
        return null;// clientPage;
    }

    @Override
    @PutMapping("/{id}")
    public Client update(@RequestBody Client clientDTO, @PathVariable("id") Long id) {
        return service.update(clientDTO, id);
    }

    @PostMapping("/withdraw/{clinentId}/{productId}/{productWithdrawalAmount}")//withdrawal
    @ResponseStatus(HttpStatus.CREATED)
    public boolean processWithdrawal(@PathVariable("clinentId") Long clinentId, @PathVariable("productId") Long productId, @PathVariable("productWithdrawalAmount") BigDecimal productWithdrawalAmount) throws ParseException {
        Optional<Client> client = service.findById(clinentId);
        Product product = productDAO.findById(productId).orElse(null);

        //assert product != null;
        double availableBalance = product.getBalance().doubleValue();
        double requestedWithdrawalAmount  = productWithdrawalAmount.doubleValue();

        if (product.getType().equalsIgnoreCase("SAVINGS") && requestedWithdrawalAmount > availableBalance) {

                logger.info("You cannot withdraw amount greater than " + availableBalance);

                return false;
        }
        if (!client.isPresent() || product == null || productWithdrawalAmount.compareTo(BigDecimal.ZERO) <= 0) {
                return false;
            }
            System.out.println("############################# client is present and move on");

            if (product.getType().equalsIgnoreCase("RETIREMENT") && !isClientAtRetirement(client)) {
                logger.info("client is at retirement and is at retirement");
                return false;
            }
            System.out.println("############################# Product type = " + product.getType());

            BigDecimal currentBalance = product.getBalance();//getting current balcnce from product in db
            if (productWithdrawalAmount.compareTo(currentBalance.multiply(new BigDecimal("0.9"))) > 0) {
                return false;
            }
            System.out.println("############################# Assigning values");
            WithdrawalProcess widrawal = new WithdrawalProcess();
            widrawal.setClient(client.get());
            widrawal.setProduct(product);
            widrawal.setWithdrawalAmount(productWithdrawalAmount);
            widrawal.setStatus("STARTED");

        logger.info("Withdrawal Status : "+widrawal.getStatus());


            widrawal.setPreviousBalance(currentBalance);
            widrawal.setLastupdated(LocalDateTime.now());
            withDrawalDAO.save(widrawal);

            BigDecimal newBalance = currentBalance.subtract(productWithdrawalAmount);
            product.setBalance(newBalance);
            widrawal.setStatus("EXECUTING");
            withDrawalDAO.save((WithdrawalProcess) widrawal);
            logger.info("Withdrawal Status : "+widrawal.getStatus());


            widrawal.setStatus("DONE");
        logger.info("Withdrawal Status : "+widrawal.getStatus());

        widrawal.setPreviousBalance(currentBalance);
            widrawal.setLastupdated(LocalDateTime.now());
            withDrawalDAO.save(widrawal);
            return true;
    }

    public boolean isClientAtRetirement(Optional<Client> client) throws ParseException {
        logger.info("Inside  isClientAtRetirement");

        Date birthdayFromDOB = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(client.get().getDateOfBirth().toLocalDate()));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthdayFromDOB);
        logger.info("Age is " + birthdayFromDOB);
        LocalDate today = LocalDate.now();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        LocalDate birthday = LocalDate.of(year, month, day);
        Period period = Period.between(birthday, today);

        logger.info("Client has "+period.getYears()+" years ");
        //set true if years is equal or greater than 65
        return period.getYears() >= 65;
    }

}
