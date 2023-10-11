package za.co.momentum.investment.app.service;

import za.co.momentum.investment.app.entity.Client;
import za.co.momentum.investment.app.entity.ClientProductItem;

import java.util.List;
import java.util.Optional;

public interface ClientProductItemService {


    ClientProductItem  save(ClientProductItem entity);
    void deleteById(long id);
    List<ClientProductItem> findClientProductById(long  id);
    List<ClientProductItem> findAll();

    ClientProductItem update(ClientProductItem client, Long id);
}
