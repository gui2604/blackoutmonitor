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

## Collection - Postman
### Em anexo no arquivo GS Blackoutmonitor.postman_collection.json

## 💡 Sobre o Projeto
### O projeto do Blackout Monitor consiste em uma solução para fazer a diferença em comunidades menos abastadas por recursos que auxiliem de fora ágil e eficiente na identificação de quedas de energia proporcionando respostas mais imediatas a esse tipo de incidente, reduzindo a vulnerabilidade e exposições de risco para a população mais carente afetada.
### Para isso, a solução consiste em dispositivos de medição de luminosidade e corrente eletrica distribuído por essas zonas, periodicamente coletando dados e enviando para o servidor. O servidor consiste em uma api em Java que irá fornecer o gerenciamento de usuários, permitindo cadastro e login, e o armazenamento de informações a respeito dos dispositivos e informações sobre os locais em que eles estão distribuídos em um banco de dados H2. Essas operações serão requisitadas pelo aplicativo mobile que realizará chamadas nesse servidor e devolverá para o APP os recursos, permitindo exibições de dashboards construídos por meio de análises desses dados a respeito das regiões afetadas pelo problema de energia elétrica. 


---

## 🛠️ Tecnologias Utilizadas

	- Java 17
	- Spring Boot
 	- Spring Web
 	- Spring Security
 	- Spring Data JPA
	- Maven (Gerenciamento de dependências)
	- H2 Database (banco em memória para testes)
	- Lombok (para reduzir boilerplate code)
	- JPA/Hibernate (persistência de dados)

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
```
# Clone o repositório
git clone https://github.com/gui2604/blackoutmonitor.git
cd blackoutmonitor

# Compile e execute
./mvnw spring-boot:run

# Testes:
./mvnw test

# Docker
## A aplicação está disponibilizada em um container publico:
docker pull gui2604/blackout-monitor:1.0.0
docker run --name container-blackout-monitor -p 8080:8080 gui2604/blackout-monitor:1.0.0

# Postman
### A collection do Postman do projeto está em anexo dentro da raiz do diretório da aplicação. Podendo ser importada e utilizada para testes locais com o uso do Postman.
