Student Attendance Management System

A simple and efficient backend project built using Java, Spring Boot, and MySQL to manage student attendance records.

Features

- Create and manage student records
- Mark and view student attendance
- Relational mapping between students and attendance entries
- Clean REST API endpoints using Spring Boot
- Data persistence using MySQL

Tech Stack

- *ava 17+
- pring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Lombok
- Maven


API Endpoints Sample

| Method | Endpoint              | Description                   |
|--------|-----------------------|-------------------------------|
| POST   | `/students`           | Create a new student          |
| GET    | `/students`           | Get all students              |
| POST   | `/attendance`         | Mark student attendance       |
| GET    | `/attendance`         | View all attendance records   |
| GET    | `/attendance/{id}`    | View attendance by student ID |

Configuration (application.properties)

spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


