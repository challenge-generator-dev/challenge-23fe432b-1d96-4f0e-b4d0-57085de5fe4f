package domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

// Cliente de la plataforma de préstamos. Identificado por su DNI, que es único en el negocio.
@jakarta.persistence.Entity
@Table(name = "customers")
public class CustomerEntity extends Entity {

    @NotNull(message = "Name cannot be null")
    @Size(min = 1, max = 150, message = "Name must have between 1 and 150 characters")
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @NotNull(message = "DNI cannot be null")
    @Size(min = 7, max = 15, message = "DNI must have between 7 and 15 characters")
    @Column(name = "dni", nullable = false, unique = true, length = 15)
    private String dni;

    protected CustomerEntity() {
    }

    public CustomerEntity(Long id, String name, String dni) {
        super(id);
        setName(name);
        setDni(dni);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = Objects.requireNonNull(dni, "DNI cannot be null");
    }
}