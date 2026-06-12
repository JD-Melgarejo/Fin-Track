# Fin-Track

# FinTrack

## Descripción General

FinTrack es una aplicación de escritorio desarrollada en Java cuyo objetivo es facilitar la gestión financiera personal mediante el registro y control de gastos asociados a un usuario autenticado.

El sistema utiliza Oracle Database como motor de base de datos para garantizar la persistencia de la información y permitir la administración estructurada de los datos financieros.

---

## Objetivo del Proyecto

Desarrollar una aplicación que permita a los usuarios registrar y consultar movimientos financieros personales mediante una interfaz gráfica intuitiva y una arquitectura organizada basada en modelos, vistas y acceso a datos.

---

## Tecnologías Utilizadas

### Lenguaje de Programación

* Java

### Base de Datos

* Oracle Database XE

### Entorno de Desarrollo

* Apache NetBeans

### Librerías Utilizadas

* Java Swing
* JDBC (Java Database Connectivity)

---

## Arquitectura del Proyecto

El proyecto está organizado en diferentes capas para facilitar el mantenimiento y escalabilidad de la aplicación.

### Database

Contiene la gestión de conexión con Oracle Database.

### Model

Representa las entidades de negocio utilizadas por el sistema.

Ejemplos:

* Usuario
* Gasto
* Cuenta

### Service

Contiene las clases DAO (Data Access Object) encargadas de realizar operaciones CRUD sobre la base de datos.

### View

Contiene todas las interfaces gráficas desarrolladas con Java Swing.

### Session

Administra la información del usuario autenticado durante la ejecución de la aplicación.

---

## Funcionalidades Implementadas

### Autenticación de Usuarios

* Inicio de sesión mediante usuario y contraseña.
* Validación de credenciales contra Oracle Database.
* Gestión de sesión del usuario autenticado.

### Gestión de Gastos

* Registro de nuevos gastos.
* Validación de datos obligatorios.
* Almacenamiento temporal en tabla de visualización.
* Persistencia de información en Oracle Database.
* Consulta y visualización de gastos registrados.
* Asociación de gastos a usuarios del sistema.

### Gestión de Cuentas

* Estructura inicial para administración de cuentas financieras.
* Asociación de cuentas a usuarios.

---

## Flujo General del Sistema

1. El usuario inicia sesión.
2. El sistema valida las credenciales.
3. Se crea la sesión del usuario.
4. El usuario accede al módulo de gastos.
5. Se registran nuevos gastos.
6. Los gastos son almacenados en Oracle Database.
7. El sistema consulta y muestra los registros almacenados.

---

## Base de Datos

Las principales tablas implementadas son:

### USR

Almacena la información de los usuarios registrados.

### USR_LOGIN

Registra los inicios de sesión realizados por los usuarios.

### GASTO

Almacena los gastos registrados dentro del sistema.

### CUENTA

Almacena las cuentas financieras asociadas a cada usuario.

---

## Funcionalidades Futuras

Las siguientes funcionalidades se encuentran contempladas para futuras versiones:

* Gestión de categorías.
* Gestión de ingresos.
* Dashboard financiero.
* Reportes financieros.
* Exportación de información a Excel.
* Filtros avanzados de búsqueda.
* Gestión completa de cuentas financieras.

---

## Autor

Proyecto académico desarrollado por Juan como práctica de desarrollo de aplicaciones Java conectadas a Oracle Database.
