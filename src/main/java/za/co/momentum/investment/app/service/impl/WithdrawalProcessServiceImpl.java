package za.co.momentum.investment.app.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import za.co.momentum.investment.app.dao.WithdrawalProcessRepository;
import za.co.momentum.investment.app.entity.WithdrawalProcess;
import za.co.momentum.investment.app.service.WithdrawalProcessService;

import java.util.List;
import java.util.Optional;

@Service
public class WithdrawalProcessServiceImpl implements WithdrawalProcessService {

    private final WithdrawalProcessRepository withdrawalProcessRepository;

    public WithdrawalProcessServiceImpl(WithdrawalProcessRepository withdrawalProcessRepository) {
        this.withdrawalProcessRepository = withdrawalProcessRepository;
    }


    @Override
    public WithdrawalProcess save(WithdrawalProcess entities) {

        return withdrawalProcessRepository.save(entities);
    }

    @Override
    public void deleteById(Long id) {
       withdrawalProcessRepository.deleteById(id);
    }

    @Override
    public Optional<WithdrawalProcess> findById(Long id) {

          return Optional.of(withdrawalProcessRepository.findById(id).get());

    }

    @Override
    public List<WithdrawalProcess> findAll() {
        return withdrawalProcessRepository.findAll();
    }

    @Override
    public Page<WithdrawalProcess> findAll(Pageable pageable) {
        return withdrawalProcessRepository.findAll(pageable);
    }

    @Override
    public WithdrawalProcess update(WithdrawalProcess entity, Long id) {
        return withdrawalProcessRepository.save(entity);
    }
}
