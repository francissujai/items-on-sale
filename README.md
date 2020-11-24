# itemsonsale application
Sample itemsonsale Application using Spring Boot framework.

How to Run the application?
1) Install MySQL
2) Create a database named itemsonsale
3) Execute this commamd from the project root folder : mvn clean install
4) Execute this command from project root folder : mvn spring-boot:run -Dspring-boot.run.profiles=local
5) Execute the day_zero_inserts.sql file which is under src/main/resources
6) Execute the request named "Get Recommendations" from postman collection, collection is available under src/main.resources folder.

