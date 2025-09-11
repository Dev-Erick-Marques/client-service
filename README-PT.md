# Costumer Service

O *Costumer Service* é um microsserviço responsável pelo gerenciamento dos clientes da plataforma.
Ele gerencia o registro, a recuperação, a exclusão reversível e a restauração dos clientes.
A autenticação e a autorização são baseadas em tokens JWT.

## Funcionalidades

- Registrar novos costumers usando `idUser` do token JWT
- Buscar costumer por ID
- Listar todos os costumers
- Realizar exclusão lógica (soft delete) de um costumer por ID
- Restaurar costumer excluído logicamente por ID

## Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security + JWT**
- **Flyway** (database migrations)
- **PostgreSQL**


## Endpoints
### URL Base: `/costumers`

### Rotas disponiveis

| Metodo | Endpoint        | Descrição                                          | Autenticação |
|--------|-----------------|----------------------------------------------------|--------------|
| POST   | `/register`     | Registrar novo cliente a partir do `idUser` do JWT | ✅            |
| GET    | `/{id}`         | Buscar cliente por ID                              | ✅            |
| GET    | `/all`          | Listar todos os clientes                           | ✅            |
| PATCH  | `/{id}/delete`  | Realizar exclusão lógica do cliente por ID         | ✅            |
| PATCH  | `/{id}/restore` | Restaurar cliente excluído logicamente             | ✅            |

## Próximos Passos

- Validar CPF/CNPJ automaticamente
- Método para atualizar clientes
- Implementação de Roles
- Documentação com o Swagger

