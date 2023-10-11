package za.co.momentum.investment.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.co.momentum.investment.app.entity.ClientProductItem;

import java.util.List;

@Repository
public interface ClientProductItemRepository  extends JpaRepository<ClientProductItem, Long> {

//    @Query("SELECT u FROM ClientProductItem u WHERE u.product_id = ?1 and u.client_id = ?2")
//    List<ClientProductItem> findClientProductsByClientIdAndProductId(long product_id, long client_id);


   // @Query("SELECT u FROM ClientProductItem u WHERE u.client_id = ?1")
    List<ClientProductItem> findClientProductItemByClientId(long client_id);
}
