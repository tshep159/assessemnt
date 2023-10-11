package za.co.momentum.investment.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import za.co.momentum.investment.app.entity.Client;
import za.co.momentum.investment.app.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(Product entity);

    List<Product> save(List<Product> entities);

    void deleteById(Long id);

    Optional<Product> findById(Long id);

    List<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    Product update(Product entity, Long id);
}