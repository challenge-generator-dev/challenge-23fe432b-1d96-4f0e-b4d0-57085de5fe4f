package domain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Préstamo: pertenece a un cliente (muchos préstamos por cliente) y agrupa sus pagos.
// La clase de dominio hereda de domain.model.Entity; la anotación de JPA se referencia
// con su nombre completo para no chocar con esa clase del mismo paquete.
@jakarta.persistence.Entity
@Table(name = "loans")
public class LoanEntity extends Entity {

    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be positive")
    private BigDecimal amount;

    @NotNull(message = "Loan date cannot be null")
    @Column(name = "loan_date", nullable = false)
    private LocalDate loanDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentEntity> payments = new ArrayList<>();

    protected LoanEntity() {
    }

    public LoanEntity(Long id, BigDecimal amount, LocalDate loanDate, CustomerEntity customer) {
        super(id);
        setAmount(amount);
        setLoanDate(loanDate);
        setCustomer(customer);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        Objects.requireNonNull(amount, "Amount cannot be null");
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.amount = amount;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = Objects.requireNonNull(loanDate, "Loan date cannot be null");
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = Objects.requireNonNull(customer, "Customer cannot be null");
    }

    public List<PaymentEntity> getPayments() {
        return payments;
    }

    public void addPayment(PaymentEntity payment) {
        Objects.requireNonNull(payment, "Payment cannot be null");
        payments.add(payment);
        payment.setLoan(this);
    }

    public void removePayment(PaymentEntity payment) {
        Objects.requireNonNull(payment, "Payment cannot be null");
        payments.remove(payment);
        payment.setLoan(null);
    }
}