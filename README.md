# Normalización de Modelo de Datos en una Plataforma de Préstamos

La empresa de préstamos 'Préstamos Rápidos' necesita un modelo de datos normalizado para su plataforma de gestión de préstamos. El objetivo es reducir redundancias y prevenir anomalías de inserción, actualización y eliminación. Debes diseñar un modelo Entidad-Relación y aplicar las formas normales. Las entidades clave son Clientes, Préstamos y Pagos. Los atributos principales son Nombre, DNI, Monto, Fecha de Préstamo, Fecha de Pago y Monto de Pago. Las relaciones son Cliente-Préstamo (uno a muchos) y Préstamo-Pago (uno a muchos).

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Diseño e Implementación de un Modelo de Datos Normalizado |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 10 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Tener el proyecto base del reto funcionando en tu máquina: clonar el repositorio, instalar las herramientas y verificar que compila y arranca antes de empezar a practicar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Instala las herramientas para ejecutar el proyecto: JDK 17+ y Maven 3.9+.
- Clona el repositorio del reto (el enlace viene en la entrega del reto y en la sección "Repositorio del Proyecto" del PDF) y ábrelo en tu IDE.
- Instala las dependencias y compila ejecutando `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q` en la raíz del repositorio.
- Confirma que el comando termina sin errores: el proyecto arranca y sus pruebas corren.
- Ubica los archivos de práctica: son los que contienen `TODO(reto)` (búscalos en el repositorio). Lee el README.md y el AGENTS.md antes de empezar.

**Entregable:** El proyecto compila/arranca sin errores con `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q`.

<details>
<summary>Pistas de conocimiento</summary>

- Los archivos con `TODO(reto)` son el ejercicio: el resto del repositorio ya está resuelto y no hace falta tocarlo.
- Si el comando de verificación falla, revisa la versión de las herramientas instaladas antes de modificar código.
- AGENTS.md describe el reto, el comando de verificación y las reglas del repositorio.

</details>

### Fase 1: Diseño del Modelo Entidad-Relación

**Objetivo:** Crear un modelo Entidad-Relación coherente con los requerimientos del negocio.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- El modelo debe incluir entidades, atributos y relaciones identificadas.
- Debe ser coherente con los requerimientos del negocio (ejemplo: sistema de pedidos con clientes, productos y órdenes).
- Validar que el modelo cumpla con la evidencia estática definida en la restricción c1.

**Entregable:** Modelo Entidad-Relación en formato diagrama (archivo .erd o equivalente)

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda que las entidades deben representar conceptos del dominio.
- Las relaciones deben reflejar cómo interactúan las entidades.

</details>

### Fase 2: Aplicación de Formas Normales

**Objetivo:** Aplicar las formas normales al modelo Entidad-Relación para reducir redundancias y prevenir anomalías.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Aplicar 1NF, 2NF y 3NF al modelo diseñado en f1.
- Documentar las decisiones de normalización (ejemplo: división de tablas, creación de claves foráneas).
- Validar que el modelo cumpla con la evidencia estática definida en la restricción c1.

**Entregable:** Modelo Entidad-Relación normalizado en formato diagrama (archivo .erd o equivalente)

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda las definiciones y propósitos de las formas normales.
- Identifica y elimina redundancias y anomalías en tu modelo.

</details>

### Fase 3: Implementación en Spring Data JPA y PostgreSQL

**Objetivo:** Implementar el modelo de datos normalizado en una base de datos usando Spring Data JPA y PostgreSQL.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Crea las tablas en PostgreSQL según el modelo normalizado.
- Configura Spring Data JPA para mapear las entidades y relaciones del modelo.

**Entregable:** Código fuente con las entidades y repositorios configurados en Spring Data JPA y las tablas creadas en PostgreSQL.

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda configurar las anotaciones de Spring Data JPA para mapear las entidades y relaciones.
- Utiliza PostgreSQL para crear y gestionar las tablas del modelo normalizado.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un modelo Entidad-Relación y por qué es importante en el diseño de bases de datos?
- **paraQueSirve**: ¿Para qué sirve aplicar las formas normales en un modelo de datos?
- **comoSeUsa**: ¿Cómo se usa Spring Data JPA para mapear entidades y relaciones en una base de datos?
- **erroresComunes**: ¿Cuáles son los errores comunes al diseñar un modelo de datos y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones implica el diseño de un modelo de datos normalizado y cómo afectan al rendimiento y mantenimiento de la base de datos?

## Criterios de Evaluacion

- Diseño de un modelo Entidad-Relación coherente con los requerimientos del negocio.
- Aplicación adecuada de las formas normales para reducir redundancias y prevenir anomalías.
- Implementación correcta del modelo de datos en Spring Data JPA y PostgreSQL.

## Mapa de fases

La **Fase 0** es clonar el repositorio, instalar dependencias y correr las pruebas de aceptacion: todas fallan porque la logica de cada pieza esta pendiente.

| Fase | Pieza (skill) | Archivo:simbolo | Criterios | Prueba | Comando |
|------|---------------|-----------------|-----------|--------|---------|
| f1 — Diseño del Modelo Entidad-Relación | Modelado de entidades y relaciones en un diagrama ER | — | El modelo Entidad-Relación incluye al menos 3 entidades con sus atributos y relaciones.; El modelo evita redundancias y anomalías según las formas normales básicas. | — | — |
| f2 — Aplicación de Formas Normales | Aplicación de formas normales (1NF, 2NF, 3NF) a un modelo ER | — | El modelo normalizado cumple con 1NF, 2NF y 3NF.; Las tablas están libres de redundancias y anomalías de inserción, actualización y eliminación. | — | — |
| f3 — Implementación en Spring Data JPA y PostgreSQL | Mapeo de entidades JPA con relaciones normalizadas | — | Las entidades JPA reflejan el modelo normalizado con anotaciones correctas (@Entity, @Id, @OneToMany, etc.).; Los repositorios JPA permiten operaciones CRUD sobre las entidades.; La base de datos PostgreSQL se crea con las tablas y relaciones definidas en el modelo normalizado. | — | — |
| f3 — Implementación en Spring Data JPA y PostgreSQL | Implementación de repositorios JPA para operaciones CRUD | `src/main/java/infrastructure/repository/LoanRepository.java:OrderRepository` | Las entidades JPA reflejan el modelo normalizado con anotaciones correctas (@Entity, @Id, @OneToMany, etc.).; Los repositorios JPA permiten operaciones CRUD sobre las entidades.; La base de datos PostgreSQL se crea con las tablas y relaciones definidas en el modelo normalizado. | — | — |
| f3 — Implementación en Spring Data JPA y PostgreSQL | Definición de esquema y tablas en PostgreSQL usando Terraform | — | Las entidades JPA reflejan el modelo normalizado con anotaciones correctas (@Entity, @Id, @OneToMany, etc.).; Los repositorios JPA permiten operaciones CRUD sobre las entidades.; La base de datos PostgreSQL se crea con las tablas y relaciones definidas en el modelo normalizado. | — | — |

## Pruebas de aceptacion

Las pruebas de aceptacion (columna "Prueba" de la tabla) son de **solo lectura**: definen que significa "listo". No las edites, no las borres y no les agregues `skip`; lo que se resuelve es el codigo de cada pieza.

## Restricciones del pedido

| Restriccion | Donde se cumple | Estado |
|-------------|-----------------|--------|
| Diseñó un modelo Entidad‑Relación coherente con los requerimientos y normalizó las tablas de manera adecuada. Identificó entidades, atributos y relaciones, y aplicó las formas normales para reducir redundancias y prevenir anomalías de inserción, actualización y eliminación | chequeo estatico (code): exige `1NF`, `2NF`, `3NF`, `foreign key`, `primary key`, `many-to-one`, `one-to-many`; prohibe `redundant`, `duplicate`, `update anomaly`, `insert anomaly`, `delete anomaly` | Restriccion no verificada en chequeo estatico (code): exige `1NF`, `2NF`, `3NF`, `foreign key`, `primary key`, `many-to-one`, `one-to-many`; prohibe `redundant`, `duplicate`, `update anomaly`, `insert anomaly`, `delete anomaly` |

## Mapa de componentes

El repo tiene una carpeta por componente. Cada uno se instala y verifica dentro de la suya.

| Componente | Carpeta | Rol | Capa | Track | Tecnologias |
|---|---|---|---|---|---|
| `app` | (raiz) | practice, chapter | server | Java | Spring Data JPA, PostgreSQL |
| `infra-local` | (raiz) | support | infra | Compose local | PostgreSQL |

## Orden de arranque

1. `docker compose up -d` (en la raiz) — levanta la infraestructura local.
2. `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` — componente `app` (practice, chapter).

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
