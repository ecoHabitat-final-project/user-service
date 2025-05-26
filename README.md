#  User Service - EcoHabitats Platform

Este microservicio gestiona los usuarios dentro de la plataforma distribuida **EcoHabitats**. El `user-service` es responsable de registrar, consultar, actualizar y eliminar los perfiles de usuario, proporcionando un backend robusto para la gestión de identidad ecológica.

---

##  Tecnologías Utilizadas

- **Java 21**
- **Spring Boot 3.4.6**
- **Spring Cloud 2024.0.1**
- **Spring Data JPA**
- **MySQL**
- **Eureka Discovery Client**
- **Feign Client**
- **Swagger / OpenAPI (springdoc-openapi 2.3.0)**

---

##  Estructura

```
com.ecohabitat.user_service
├── controllers         # Endpoints REST de usuario
├── dto                 # Transferencia de datos (entrada/salida)
├── exceptions          # Excepciones personalizadas y handler global
├── models              # Entidades JPA (User, Role, etc.)
├── repositories        # Interfaces JPA para persistencia
├── services            # Lógica de negocio de usuario
└── UserServiceApplication.java
```

---

## 🔗 Endpoints

| Método | Endpoint                              | Descripción                        |
|--------|---------------------------------------|------------------------------------|
| GET    | `/api/user`                           | Listar todos los usuarios          |
| GET    | `/api/user/{id}`                      | Obtener usuario por ID             |
| POST   | `/api/user`                           | Crear un nuevo usuario             |
| PATCH  | `/api/user/update/{userId}`           | Actualizar usuario existente       |
| DELETE | `/api/user/delete/{userId}`           | Eliminar usuario por ID            |

---

##  Gestión de Excepciones

La gestión de errores se centraliza mediante `@RestControllerAdvice`, manejando:

- `UserNotFoundException` → 404 Not Found
- `DuplicateUserException` (si aplica) → 409 Conflict




---

## ⚙️ Configuración `application.properties` (resumen)

```properties
spring.application.name=user-service
server.port=8082

spring.datasource.url=jdbc:mysql://localhost:3306/user_service
spring.datasource.username=*****
spring.datasource.password=*****

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

eureka.client.service-url.defaultZone=http://localhost:8081/eureka/
```

---

## Cómo Ejecutar

1. Verifica que MySQL y Eureka Server estén activos.
2. Ejecuta el microservicio:

3. Asegúrate de que esté registrado en:
   [http://localhost:8081/eureka](http://localhost:8081/eureka)

---

 servicio forma parte del proyecto de fin de formación con arquitectura de microservicios en Java.

---

## Estado del Servicio

- [x] CRUD de usuarios
- [x] Integración con Eureka
- [x] Gestión de errores global
- [ ] Integración con Feign (desarrollo)
- [ ] Integración con Gateway (desarrollo)
- [ ] Pruebas unitarias (en curso)
- [ ] Pruebas mock (en curso)

---


Proyecto académico (IronHack BackEnd 2025)