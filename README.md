# safe-group-8195

# ER Diagram

# REST API for Covid-19 Application

# Features

# Tech Stack
- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Swagger

# Modules
- Login, Logout Module
- User Module
- Admin Module

# Contributors
- <a href="https://github.com/raj2820">Raj Shinde</a>
- <a href="https://github.com/bhupirao"> Bhoop Singh</a>
- <a href="https://github.com/Mansi-Deshmukh">Mansi Deshmukh</a>
- <a href="https://github.com/lalitarana123456">Latita Kumar</a>
- <a href="https://github.com/kieransahoo">Kiran Kumar Sahoo</a>


# Installation and Run
- Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database config.

 
server.port=8880


 
spring.datasource.url=jdbc:mysql://localhost:3306/ll
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root

 #ORM s/w specific properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

-spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
# API Root Endpoint
https://localhost:8880/

http://localhost:8880/swagger-ui/
