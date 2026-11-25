package domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.util.Objects;

/**
 * Entidad base del modelo Entidad-Relación.
 *
 * Normalización aplicada:
 * - 1NF: cada atributo contiene un valor atómico y no hay grupos repetitivos.
 * - 2NF: todos los atributos no clave dependen de la clave primaria completa (id).
 * - 3NF: no existen dependencias transitivas entre atributos no clave.
 *
 * Clave primaria: id (generado por la base de datos).
 */
@MappedSuperclass
public abstract class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected Entity() {
    }

    protected Entity(Long id) {
        this.id = Objects.requireNonNull(id, "Id cannot be null");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = Objects.requireNonNull(id, "Id cannot be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return id != null && id.equals(entity.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}