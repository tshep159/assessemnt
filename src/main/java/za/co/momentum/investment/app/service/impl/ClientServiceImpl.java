package za.co.momentum.investment.app.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import za.co.momentum.investment.app.dao.ClientRepository;
import za.co.momentum.investment.app.entity.Client;
import  za.co.momentum.investment.app.service.*;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientDAO;

    @Override
    public Client save(Client entity) {
        return clientDAO.save(entity);
    }

    @Override
    public void deleteById(long id) {
        clientDAO.deleteById(id);
    }

    @Override
    public Optional<Client> findById(long id) {
        return Optional.of(clientDAO.findById(id).get());
    }

    @Override
    public List<Client> findAll() {
        return (List<Client>) clientDAO.findAll();
    }

    @Override
    public Client update(Client client, Long id) {
        return null;
    }
}
