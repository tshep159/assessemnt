package za.co.momentum.investment.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import za.co.momentum.investment.app.entity.WithdrawalProcess;

import java.util.List;
import java.util.Optional;

public interface WithdrawalProcessService {
    WithdrawalProcess save(WithdrawalProcess entities);

    void deleteById(Long id);

    Optional<WithdrawalProcess> findById(Long id);

    List<WithdrawalProcess> findAll();

    Page<WithdrawalProcess> findAll(Pageable pageable);

    WithdrawalProcess update(WithdrawalProcess entity, Long id);
}
