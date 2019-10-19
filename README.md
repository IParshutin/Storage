# Storage

![screenshot of sample](https://sun9-58.userapi.com/c858028/v858028202/b181f/o9BUjaiLn78.jpg)

This app is created to review the  Vaadin and Spring frameworks. The application provides the ability to create, read, update and delete information from the database.

You can change the way the application works with the database. To do this, change the parameter `spring.jpa.hibernate.ddl-auto` in file **application.properties**. 

Parameter `spring.jpa.hibernate.ddl-auto` can be:
 - **none**: No change is made to the database structure.
 - **update**: Hibernate changes the database according to the given entity structures.
 - **create**: Creates the database every time but does not drop it on close.
 - **create-drop**: Creates the database and drops it when SessionFactory closes.

By default, the application works with the database in mode "create-drop"
```
spring.jpa.hibernate.ddl-auto=create-drop
...
```
This mode is selected because the application is distributed without a database file. When you first start the application will create a database. In the future, the mode can be switched to save data.


## Stack
 - Vaadin 
 - Spring-boot
 - H2 Database

## Requirements
 - Java 8
 - Maven 3.5

## Getting started
Follow these steps to launch the application:

1. Download project source code
```
git clone https://github.com/IParshutin/Storage.git
```    
2. Go to the project folder
```
cd Storage
```
3. Launch the application using maven
```
mvn spring-boot:run
```
4. After starting the application, follow the link <http://localhost:8080>
