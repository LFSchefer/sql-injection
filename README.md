# Welcome to the _sql-injection_ workshop 

Install the project, to start hacking !

This project uses : Java Spring Boot, Maven, PostgreSql and React.

## Installation
### DataBase
Create your DB.
```sql
CREATE DATABASE sql_injection;
```
When your project and your database are connected, run these scripts :

1 - `shema.DDL.sql`

2 - `DML.sql`

### Backend
1 - With Eclipse (or your favorite IDE) open the project in directory `sql-injection_api`.
> Note: import and choose `Existing Maven Project` 
 Structure : 
 
 ![image](https://github.com/user-attachments/assets/970c39f8-0dcd-419e-b42e-9b254fb0e2f4)

 
 3- In `application.properties`, fill :
 ```
spring.application.name=sql-injection-api
spring.datasource.url=jdbc:postgresql://localhost:###YOUR PORT###/###YOUR DATABASE NAME###
spring.datasource.username=###YOUR USERNAME###
spring.datasource.password=###YOUR PASSWORD###
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
 ```
 
 4- Run as `Spring Boot App`

### Front-end
Open `sql-injection-ui` with Visual Studio Code (or other).

Run 
```bash
npm install
```
And launch the server :
```bash
npm run dev
```

The project is installed. :tada:
