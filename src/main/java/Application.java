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