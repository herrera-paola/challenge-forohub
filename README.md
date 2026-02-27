# Foro Hub - Challenge Backend Alura 🚀

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white)

---

## 📌 Descripción

¡Bienvenido a **Foro Hub**! 🚀  

Esta es una API REST desarrollada en Java con Spring Boot como parte del Challenge Backend de Alura.  
El proyecto permite gestionar tópicos de un foro, incluyendo su creación, consulta, actualización y eliminación lógica, aplicando reglas de negocio y seguridad con autenticación JWT.

---

## 📋 Características

- **CRUD de Tópicos**: Registro, listado paginado, detalle, actualización y eliminación (borrado lógico).
- **Reglas de negocio**: Validación para evitar el registro de tópicos duplicados (mismo título y mensaje).
- **Seguridad**: Autenticación y autorización basadas en **JWT (JSON Web Tokens)**.
- **Documentación interactiva**: Implementación de **Swagger (SpringDoc OpenAPI)** para probar los endpoints desde el navegador.
- **Persistencia de datos**: Integración con base de datos **MySQL**.
- **Migraciones**: Gestión de versiones de la base de datos con **Flyway**.

---

## 🛠️ Tecnologías Utilizadas

- Java 17  
- Spring Boot 3.x  
- Spring Security (Autenticación con JWT)  
- Spring Data JPA  
- MySQL Driver  
- Flyway  
- Lombok  
- SpringDoc OpenAPI (Swagger)  

---

## 🚀 Cómo Ejecutar el Proyecto

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/herrera-paola/challenge-forohub.git
cd challenge-forohub
```

### 2️⃣ Configurar la base de datos

- Crear una base de datos llamada `forohub_api` en MySQL.
- Configurar las credenciales en:

```
src/main/resources/application.properties
```

Ejemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/forohub_api
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
```

### 3️⃣ Ejecutar la aplicación

```bash
mvn spring-boot:run
```

---

## 📖 Documentación de la API

Una vez ejecutada la aplicación, puedes acceder a la interfaz de Swagger en:

👉 http://localhost:8080/swagger-ui.html
