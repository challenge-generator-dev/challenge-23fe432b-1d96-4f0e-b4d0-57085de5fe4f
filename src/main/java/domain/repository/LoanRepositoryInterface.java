package domain.repository;

import domain.model.LoanEntity;
import java.util.List;
import java.util.Optional;

public interface LoanRepositoryInterface {
    LoanEntity save(LoanEntity loan);
    Optional<LoanEntity> findById(Long id);
    List<LoanEntity> findAll();
    void deleteById(Long id);
    List<LoanEntity> findByCustomerId(Long customerId);
}