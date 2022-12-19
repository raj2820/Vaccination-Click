# Vaccination Click

# ER Diagram

<img src="covid19db.png">

# REST API for Covid-19 Application
We have developed this REST API for an Covid-19 Application. This API performs all the fundamental CRUD operations of any Covid-19 Application platform with user validation at every step.

# Modules
- Login, Logout Module
- User Module
- Admin Module

# Features
 User and Admin authentication & validation with session uuid.
 
* Admin Features:
 
Administrator Role of the entire application

Admin can access the details of different Member ,Vaccine Center ,Vaccine Inventory and Vaccine Ragistration.

* User Features:
A user can register himself or herself on the platform.

User can check the vaccine centres and vaccine availabilty.

User can register for vaccine. User can register more then one member.

After booking an appointment, he will get appointment details for the vaccine dose.

# Tech Stack
- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Swagger



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


spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
# API Root Endpoint
https://localhost:8880/

http://localhost:8880/swagger-ui/index.html
