# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/infrastructure/repository/LoanRepository.java` — La pieza p4 (Implementación de repositorios JPA para operaciones CRUD, fase f3) vive aqui: este archivo es su unico dueno (blueprint v2).

## Mapa de componentes

El repo tiene una carpeta por componente. Cada uno se instala y verifica dentro de la suya.

| Componente | Carpeta | Rol | Capa | Track | Tecnologias |
|---|---|---|---|---|---|
| `app` | (raiz) | practice, chapter | server | Java | Spring Data JPA, PostgreSQL |
| `infra-local` | (raiz) | support | infra | Compose local | PostgreSQL |

## Orden de arranque

1. `docker compose up -d` (en la raiz) — levanta la infraestructura local.
2. `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` — componente `app` (practice, chapter).

## Como saber que terminaste

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced L2

### Brecha de conocimiento
Implementa un proceso de normalización en una base de datos según las formas normales y ha usado un modelo Entidad-Relación.

### Reto
- Tema: Diseño e Implementación de un Modelo de Datos Normalizado
- Seniority: advanced-l2
- Tipo: practical
- Título: Normalización de Modelo de Datos en una Plataforma de Préstamos
- Tiempo estimado: 10 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Diseño del Modelo Entidad-Relación — objetivo: Crear un modelo Entidad-Relación coherente con los requerimientos del negocio. — entregable (NO resolver): Modelo Entidad-Relación en formato diagrama (archivo .erd o equivalente)
- Fase 2: Aplicación de Formas Normales — objetivo: Aplicar las formas normales al modelo Entidad-Relación para reducir redundancias y prevenir anomalías. — entregable (NO resolver): Modelo Entidad-Relación normalizado en formato diagrama (archivo .erd o equivalente)
- Fase 3: Implementación en Spring Data JPA y PostgreSQL — objetivo: Implementar el modelo de datos normalizado en una base de datos usando Spring Data JPA y PostgreSQL. — entregable (NO resolver): Código fuente con las entidades y repositorios configurados en Spring Data JPA y las tablas creadas en PostgreSQL.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (entrega de archivos).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.13</version>
        <relativePath/>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>reto</artifactId>
    <version>1.0.0</version>
    <name>reto</name>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>jakarta.persistence</groupId>
            <artifactId>jakarta.persistence-api</artifactId>
        </dependency>
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>7.4.17.Final</version>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/domain/model/Entity.java ===
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

// === ARCHIVO: src/main/java/domain/model/LoanEntity.java ===
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

// === ARCHIVO: src/main/java/domain/repository/LoanRepositoryInterface.java ===
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

// === ARCHIVO: src/main/java/infrastructure/config/JpaConfig.java ===
package infrastructure.config;

import domain.repository.LoanRepositoryInterface;
import infrastructure.repository.LoanRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "infrastructure.repository")
@EnableTransactionManagement
public class JpaConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("domain.model");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        jpaProperties.put("hibernate.hbm2ddl.auto", "update");
        jpaProperties.put("hibernate.show_sql", "true");
        jpaProperties.put("hibernate.format_sql", "true");
        em.setJpaProperties(jpaProperties);

        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    public LoanRepositoryInterface loanRepository(LoanRepository loanRepository) {
        return loanRepository;
    }
}

// === ARCHIVO: src/main/java/infrastructure/repository/LoanRepository.java ===
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

// === ARCHIVO: src/main/java/infrastructure/adapter/PostgresqlSchemaAdapter.java ===
package infrastructure.adapter;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class PostgresqlSchemaAdapter {

    private static final String SCHEMA_NAME = "orders_schema";
    private static final String LOANS_TABLE = "loans";
    private static final String CUSTOMERS_TABLE = "customers";
    private static final String PAYMENTS_TABLE = "payments";

    private final DataSource dataSource;

    public PostgresqlSchemaAdapter(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void initializeSchema() {
        try (Connection connection = dataSource.getConnection()) {
            createSchemaIfNotExists(connection);
            createTablesIfNotExist(connection);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to initialize PostgreSQL schema", e);
        }
    }

    private void createSchemaIfNotExists(Connection connection) throws SQLException {
        String checkSchemaSql = 
            "SELECT schema_name FROM information_schema.schemata WHERE schema_name = '" + SCHEMA_NAME + "'";
        
        try (var stmt = connection.createStatement();
             var rs = stmt.executeQuery(checkSchemaSql)) {
            if (!rs.next()) {
                stmt.execute("CREATE SCHEMA " + SCHEMA_NAME);
            }
        }
    }

    private void createTablesIfNotExist(Connection connection) throws SQLException {
        createCustomersTable(connection);
        createLoansTable(connection);
        createPaymentsTable(connection);
    }

    private void createCustomersTable(Connection connection) throws SQLException {
        if (!tableExists(connection, CUSTOMERS_TABLE)) {
            String sql = """
                CREATE TABLE %s.%s (
                    id BIGSERIAL PRIMARY KEY,
                    name VARCHAR(255) NOT NULL,
                    dni VARCHAR(20) NOT NULL UNIQUE
                )
                """.formatted(SCHEMA_NAME, CUSTOMERS_TABLE);
            connection.createStatement().execute(sql);
        }
    }

    private void createLoansTable(Connection connection) throws SQLException {
        if (!tableExists(connection, LOANS_TABLE)) {
            String sql = """
                CREATE TABLE %s.%s (
                    id BIGSERIAL PRIMARY KEY,
                    amount DECIMAL(19,2) NOT NULL,
                    loan_date DATE NOT NULL,
                    customer_id BIGINT NOT NULL REFERENCES %s.%s(id)
                )
                """.formatted(SCHEMA_NAME, LOANS_TABLE, SCHEMA_NAME, CUSTOMERS_TABLE);
            connection.createStatement().execute(sql);
        }
    }

    private void createPaymentsTable(Connection connection) throws SQLException {
        if (!tableExists(connection, PAYMENTS_TABLE)) {
            String sql = """
                CREATE TABLE %s.%s (
                    id BIGSERIAL PRIMARY KEY,
                    payment_date DATE NOT NULL,
                    amount DECIMAL(19,2) NOT NULL,
                    loan_id BIGINT NOT NULL REFERENCES %s.%s(id)
                )
                """.formatted(SCHEMA_NAME, PAYMENTS_TABLE, SCHEMA_NAME, LOANS_TABLE);
            connection.createStatement().execute(sql);
        }
    }

    private boolean tableExists(Connection connection, String tableName) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet rs = metaData.getTables(null, SCHEMA_NAME, tableName, null)) {
            return rs.next();
        }
    }

    public Map<String, Object> getSchemaInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("schemaName", SCHEMA_NAME);
        info.put("tables", new String[]{CUSTOMERS_TABLE, LOANS_TABLE, PAYMENTS_TABLE});
        return info;
    }

    public boolean validateSchema() {
        try (Connection connection = dataSource.getConnection()) {
            return tableExists(connection, CUSTOMERS_TABLE) &&
                   tableExists(connection, LOANS_TABLE) &&
                   tableExists(connection, PAYMENTS_TABLE);
        } catch (SQLException e) {
            return false;
        }
    }
}

// === ARCHIVO: src/main/java/application.properties ===
# Configuración del servidor
server.port=${SERVER_PORT:8080}

# Configuración de la fuente de datos PostgreSQL
spring.datasource.url=jdbc:postgresql://${DB_HOST:localhost}:${DB_PORT:5432}/${DB_NAME:prestamos_db}
spring.datasource.username=${DB_USER:postgres}
spring.datasource.password=${DB_PASSWORD:postgres}
spring.datasource.driver-class-name=org.postgresql.Driver

# Configuración del pool de conexiones HikariCP
spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.connection-timeout=30000
spring.datasource.hikari.idle-timeout=600000
spring.datasource.hikari.max-lifetime=1800000

# Configuración de JPA/Hibernate
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.jdbc.batch_size=20
spring.jpa.properties.hibernate.order_inserts=true
spring.jpa.properties.hibernate.order_updates=true

# Configuración de transacciones
spring.transaction.default-timeout=30
spring.transaction rollback-on-commit-failure=true

# Configuración de validación
spring.mvc.throw-exception-if-no-handler-found=true
spring.web.resources.add-mappings=false

# Configuración de actuator
management.endpoints.web.exposure.include=health,info,metrics
management.endpoint.health.show-details=when_authorized
management.endpoint.health.probes.enabled=true
management.metrics.enable.jvm=true
management.metrics.enable.process=true
management.metrics.enable.system=true

# Configuración de logging
logging.level.root=INFO
logging.level.com.example.reto=DEBUG
logging.level.org.springframework.web=DEBUG
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
logging.level.org.hibernate.engine.jdbc.batch.internal.BatchImpl=DEBUG

# Configuración de internacionalización
spring.messages.basename=messages
spring.messages.encoding=UTF-8

# Configuración de formatos de fecha
spring.mvc.format.date=yyyy-MM-dd
spring.mvc.format.date-time=yyyy-MM-dd'T'HH:mm:ss
spring.mvc.format.time=HH:mm:ss

# Configuración de cors
spring.mvc.cors.allowed-origins=*
spring.mvc.cors.allowed-methods=GET,POST,PUT,DELETE,OPTIONS
spring.mvc.cors.allowed-headers=*
spring.mvc.cors.allow-credentials=true
spring.mvc.cors.max-age=3600

// === ARCHIVO: src/main/java/Application.java ===
package com.example.reto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import infrastructure.adapter.PostgresqlSchemaAdapter;

/*
 * Punto de entrada de la plataforma de préstamos.
 * El escaneo de componentes cubre este paquete y la capa de infraestructura,
 * donde viven la configuración JPA, los repositorios y el adaptador de esquema.
 * El repositorio de préstamos se registra una sola vez, en JpaConfig.
 */
@SpringBootApplication(scanBasePackages = {"com.example.reto", "infrastructure"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /* Inicializa el esquema al arrancar y verifica que las tablas quedaron creadas. */
    @Bean
    public CommandLineRunner initSchema(PostgresqlSchemaAdapter schemaAdapter) {
        return args -> {
            schemaAdapter.initializeSchema();
            if (!schemaAdapter.validateSchema()) {
                throw new IllegalStateException("El esquema de préstamos no quedó validado tras la inicialización");
            }
        };
    }
}

// === ARCHIVO: src/main/java/domain/model/CustomerEntity.java ===
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

// === ARCHIVO: src/main/java/domain/model/PaymentEntity.java ===
package domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

// Pago realizado sobre un préstamo. Cada pago pertenece a exactamente un préstamo.
@jakarta.persistence.Entity
@Table(name = "payments")
public class PaymentEntity extends Entity {

    @NotNull(message = "Payment date cannot be null")
    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be positive")
    @Column(name = "amount", nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_id", nullable = false)
    private LoanEntity loan;

    protected PaymentEntity() {
    }

    public PaymentEntity(Long id, LocalDate paymentDate, BigDecimal amount, LoanEntity loan) {
        super(id);
        setPaymentDate(paymentDate);
        setAmount(amount);
        this.loan = loan;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = Objects.requireNonNull(paymentDate, "Payment date cannot be null");
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

    public LoanEntity getLoan() {
        return loan;
    }

    public void setLoan(LoanEntity loan) {
        this.loan = loan;
    }
}

// === ARCHIVO: docker-compose.yml ===
# Infraestructura local del reto. SOLO desarrollo: credenciales de ejemplo (local-dev-only), puertos en loopback.
# Levantar: docker compose up -d --wait
name: infra-local
services:
  postgres:
    image: "postgres:16.4-alpine"
    ports:
      - "127.0.0.1:5432:5432"
    environment:
      POSTGRES_USER: "app"
      POSTGRES_PASSWORD: "local-dev-only"
      POSTGRES_DB: "app"
    volumes:
      - "./infra-local/postgres/init.sql:/docker-entrypoint-initdb.d/init.sql:ro"
    healthcheck:
      test: ["CMD-SHELL","pg_isready -U app -d app"]
      interval: 10s
      timeout: 5s
      retries: 10
      start_period: 10s


// === ARCHIVO: infra-local/README.md ===
# Infraestructura local

Servicios de soporte para el reto, definidos en `docker-compose.yml` (raiz del repo).

```bash
docker compose up -d --wait
```

| Servicio | Imagen | Puertos (host) |
|---|---|---|
| PostgreSQL | `postgres:16.4-alpine` | 5432 |

Credenciales: solo de desarrollo local (`local-dev-only`, `local`). No son secretos ni deben reutilizarse.
Los scripts de `infra-local/` (tablas, topics) se ejecutan con el compose en estado healthy.


// === ARCHIVO: infra-local/postgres/init.sql ===
-- DDL de ejemplo; se ejecuta al crear el volumen de PostgreSQL. Ajustalo a tu modelo.
CREATE TABLE IF NOT EXISTS items (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

```
