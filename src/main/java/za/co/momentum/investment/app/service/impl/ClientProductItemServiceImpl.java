package za.co.momentum.investment.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.momentum.investment.app.dao.ClientProductItemRepository;
import za.co.momentum.investment.app.entity.ClientProductItem;
import za.co.momentum.investment.app.service.ClientProductItemService;

import java.util.List;
import java.util.Optional;
@Service
public class ClientProductItemServiceImpl implements ClientProductItemService {

    @Autowired
    ClientProductItemRepository clientDAO;

    @Override
    public ClientProductItem save(ClientProductItem entity) {
        return clientDAO.save(entity);
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public List<ClientProductItem> findClientProductById(long id) {
        return clientDAO.findClientProductItemByClientId(id);
    }

    @Override
    public List<ClientProductItem> findAll() {
        return null;
    }

    @Override
    public ClientProductItem update(ClientProductItem client, Long id) {
        return null;
    }
}
