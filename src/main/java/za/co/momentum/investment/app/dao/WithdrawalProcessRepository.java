package za.co.momentum.investment.app.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.momentum.investment.app.entity.WithdrawalProcess;
import za.co.momentum.investment.app.entity.WithdrawalProcess;

@Qualifier("withdrawalProcess")
@Repository
public interface WithdrawalProcessRepository extends JpaRepository<WithdrawalProcess, Long> {
}
