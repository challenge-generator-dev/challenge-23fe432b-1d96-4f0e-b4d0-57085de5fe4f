// TODO(reto): archivo stubbeado; implementa los cuerpos.
package infrastructure.repository;

import domain.model.LoanEntity;
import domain.repository.LoanRepositoryInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LoanRepository implements LoanRepositoryInterface {

    private final JpaRepository<LoanEntity, Long> jpaRepository;

    public LoanRepository(JpaRepository<LoanEntity, Long> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public LoanEntity save(LoanEntity loan) {
      throw new UnsupportedOperationException("TODO(reto): save");
    }

    @Override
    public Optional<LoanEntity> findById(Long id) {
      throw new UnsupportedOperationException("TODO(reto): findById");
    }

    @Override
    public List<LoanEntity> findAll() {
      throw new UnsupportedOperationException("TODO(reto): findAll");
    }

    @Override
    public void deleteById(Long id) {
      throw new UnsupportedOperationException("TODO(reto): deleteById");
    }

    @Override
    public List<LoanEntity> findByCustomerId(Long customerId) {
      throw new UnsupportedOperationException("TODO(reto): findByCustomerId");
    }
}