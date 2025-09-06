# Client Service

O **Client Service** é o microsserviço responsável pelo gerenciamento de clientes da plataforma de e-commerce.  
Ele fornece endpoints para **registro, consulta, atualização e exclusão de clientes**, servindo como base para cadastros e informações pessoais.

## Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot 3**
- **Spring Data JPA**
- **Spring Web**
- **PostgreSQL**


## Endpoints Principais
| Método | Endpoint            | Descrição                |
| ------ | ------------------- | ------------------------ |
| POST   | `/api/clients`      | Cadastrar novo cliente   |
| GET    | `/api/clients`      | Listar todos os clientes |
| GET    | `/api/clients/{id}` | Buscar cliente por ID    |
| DELETE | `/api/clients/{id}` | Remover cliente          |

## Próximos Passos

- Validar CPF/CNPJ automaticamente
- Relacionar clientes com usuários (User Service)
- Método para atualizar clientes
- Spring Security para validação do JWT
- Implementação de Roles
- Integração com outros microsserviços
