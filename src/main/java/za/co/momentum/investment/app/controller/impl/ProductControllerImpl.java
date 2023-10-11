package za.co.momentum.investment.app.controller.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.co.momentum.investment.app.controller.ProductController;
import za.co.momentum.investment.app.entity.Product;
import za.co.momentum.investment.app.service.ProductService;
import java.util.List;

@RequestMapping("api/product")
@RestController
@Controller
public class ProductControllerImpl implements ProductController {
    private final ProductService productService;

    public ProductControllerImpl(ProductService productService) {
        this.productService = productService;
    }
    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody Product productDTO) {
       return productService.save(productDTO);
    }
    @Override
    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable("id") Long id) {
        Product product = productService.findById(id).orElse(null);
        return product;
       }
    @Override
    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        productService.deleteById(id);
    }

    @Override
//    @GetMapping
    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    public List<Product> list() {
         List<Product> products =  productService.findAll();
         return products;
    }

    @Override
    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/page-query", method = RequestMethod.GET)
    public Page<Product> pageQuery(Pageable pageable) {
        return null;
    }
    @Override
    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/{id}", method = RequestMethod.PUT)
    public Product update(@RequestBody Product productDTO, @PathVariable("id") Long id) {
        Product product = productService.update(productDTO,id);
         return product;
    }
}