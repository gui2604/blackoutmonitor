http://localhost:8080/swagger-ui.html
http://localhost:8080/v3/api-docs

# BlackoutMonitor

## 3ESPV - Engenharia de Software 3º Ano - Global Solution
## Guilherme Barreto Santos - RM97674
## Mateus Iago Sousa Conceição - RM550270
## Nicolas Oliveira da Silva - RM98939 


## Swagger/OpenAPI:
### http://localhost:8080/swagger-ui.html
### http://localhost:8080/v3/api-docs

## 💡 Sobre o Projeto
 // TO-DO


---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
  - Spring Web
  - Spring Security
  - Spring Data JPA
- **Maven** (Gerenciamento de dependências)
- **H2 Database** (banco em memória para testes)
- **JWT (JSON Web Token)** para autenticação
- **Lombok** (para reduzir boilerplate code)
- **JPA/Hibernate** (persistência de dados)

---

## 📁 Estrutura do Projeto

```bash
blackoutmonitor/
├── src/main/java/
│   └── br/com/fiap/blackoutmonitor/
│       ├── BlackoutmonitorApplication.java
│       ├── config/                # Configurações de segurança
│       ├── controller/            # Controladores REST (User, Auth, Healthcheck)
│       ├── dto/                   # Objetos de transferência de dados (Login, Reset de senha)
│       ├── model/                 # Entidades JPA
│       ├── repository/            # Interfaces de acesso ao banco
│       ├── service/               # Regras de negócio
│       └── teste/main/           # Possíveis testes manuais
├── src/main/resources/
│   └── application.properties    # Configurações da aplicação
├── src/test/java/
│   └── br/com/fiap/blackoutmonitor/          # Testes automatizados
├── Dockerfile                    # Containerização da aplicação
├── pom.xml                       # Gerenciador de dependências Maven
└── README.md

# Clone o repositório
git clone https://github.com/seu-usuario/blackoutmonitor.git
cd blackoutmonitor

# Compile e execute
./mvnw spring-boot:run

# Testes:
./mvnw test

# Docker
## A aplicação está disponibilizada em um container publico:
docker pull gui2604/blackout-monitor:v1.0.1
docker run --name container-blackout-monitor -p 8080:8080 gui2604/blackout-monitor:v1.0.1


