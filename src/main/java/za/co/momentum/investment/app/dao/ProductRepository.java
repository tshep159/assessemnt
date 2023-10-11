package za.co.momentum.investment.app.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import za.co.momentum.investment.app.entity.Product;

@Qualifier("product")
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}