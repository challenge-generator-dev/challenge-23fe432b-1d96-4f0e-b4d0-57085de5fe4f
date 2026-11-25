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