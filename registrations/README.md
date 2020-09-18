# Up Local application 
1. Install Java14
2. Up docker compose image in devops foulder.
`docker-compose up --build`
3. go to mysql db and create database 
4. go to mysql db and execute data.sql for insert all data  
5. `./mvmw clean install`
6. `java -jar target/registrations-0.0.1-SNAPSHOT.jar`

# Tecnologies
Spring/Spring boot/Spring security
Java14
Monolitic application
Thymeleaf 
Mysql Database
Bycrpt 

# Using

1. Home and first test
http://localhost:8080/home

user: daniel
password: 123 

2. Product 

http://localhost:8080/products/signup
http://localhost:8080/products/list

# References

https://spring.io/guides/gs/accessing-data-mysql/
https://www.appsdeveloperblog.com/spring-security-default-username-password-role/#:~:text=Add%20Spring%20Security&text=The%20default%20username%20is%3A%20user,Spring%20Boot%20project%20is%20starting.
https://www.javaguides.net/2019/04/spring-boot-thymeleaf-crud-example-tutorial.html
https://github.com/RameshMF/springboot-thymeleaf-crud-tutorial