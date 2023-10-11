package za.co.momentum.investment.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import za.co.momentum.investment.app.entity.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}