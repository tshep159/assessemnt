package za.co.momentum.investment.app.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import za.co.momentum.investment.app.dao.ProductRepository;
//import za.co.momentum.investment.app.dto.ClientDTO?;
import za.co.momentum.investment.app.entity.Client;
import za.co.momentum.investment.app.entity.Product;
import za.co.momentum.investment.app.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public Product save(Product entity) {
        return repository.save(entity);
    }

    @Override
    public List<Product> save(List<Product> entities) {

        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.of(repository.findById(id).get());
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Product update(Product entity, Long id) {
        return null;
    }
}