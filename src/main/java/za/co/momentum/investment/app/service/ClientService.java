package za.co.momentum.investment.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import za.co.momentum.investment.app.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client save(Client entity);
    void deleteById(long id);
    Optional<Client> findById(long  id);
    List<Client> findAll();

    Client update(Client client, Long id);
}
