# Costumer Service

The **Costumer Service** is a microservice responsible for managing platform costumers.  
It handles costumer registration, retrieval, soft deletion, and restoration.  
Authentication and authorization are based on JWT tokens.

[Read in Portuguese](README-PT.md)
## Features

- Register new costumers using `idUser` from JWT token
- Retrieve costumer by ID
- List all costumers
- Soft delete costumer by ID
- Restore soft deleted costumer by ID

## Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security + JWT*
- **Consul**
- **Flyway** (database migrations)
- **PostgreSQL**

## Endpoints

### Base URL: `/costumers`

### Available Routes

| Method | Endpoint        | Description                             | Auth Required |
|--------|-----------------|-----------------------------------------|---------------|
| POST   | `/register`     | Register new costumer from JWT `idUser` | ✅             |
| GET    | `/{id}`         | Get costumer by ID                      | ✅             |
| GET    | `/all`          | List all costumers                      | ✅             |
| PATCH  | `/{id}/delete`  | Soft delete costumer by ID              | ✅             |
| PATCH  | `/{id}/restore` | Restore soft deleted costumer by ID     | ✅             |

## Next Steps

- Automatically validate CPF/CNPJ (Brazilian taxpayer ID)
- Method for updating clients
- Role implementation
- Swagger documentation