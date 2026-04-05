# 🧑‍💼 Employee Management System

A RESTful API built with **Spring Boot** and **MySQL** to manage employee records. This project covers full CRUD operations using Spring Data JPA and Hibernate.

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 21 | Programming Language |
| Spring Boot 4.0.5 | Backend Framework |
| Spring Data JPA | Database ORM |
| Hibernate 7.2.7 | JPA Implementation |
| MySQL 8.0 | Database |
| Maven | Build Tool |
| Postman | API Testing |
| Eclipse IDE | Development Environment |

---

## 📁 Project Structure
EmployeeManagementSystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── pcodes/jpaproject/EMS/
│   │   │       ├── EmployeeManagementSystemApplication.java  ← Main class
│   │   │       ├── controller/
│   │   │       │   └── EmployeeController.java
│   │   │       ├── entity/
│   │   │       │   └── Employee.java
│   │   │       ├── model/
│   │   │       │   ├── EmployeeAddRequest.java
│   │   │       │   └── EmployeeAddResponse.java
│   │   │       ├── repository/
│   │   │       │   └── EmployeeRepository.java
│   │   │       └── service/
│   │   │           └── EmployeeService.java
│   │   └── resources/
│   │       └── application.properties
├── architecture.png
├── pom.xml
└── README.md

---

## ⚙️ Application Properties
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/JPAEMS
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=false
server.port=8080
```

---

## 🚀 How to Run

1. **Clone or download** the project
2. Open in **Eclipse IDE**
3. Make sure **MySQL** is running and database `JPAEMS` exists
4. Update `application.properties` with your DB credentials
5. Right-click `EmployeeManagementSystemApplication.java`
6. Click **Run As → Spring Boot App**
7. App starts at: `http://localhost:8080`

---

## 📊 Architecture Diagram
<img width="1920" height="1080" alt="Screenshot 2026-04-05 103452" src="https://github.com/user-attachments/assets/c6bd13a2-3990-4799-bee5-ed4eb039ee72" />

### Flow Explanation
Client (Postman/Browser)
↓
Controller        ← Receives HTTP requests, uses Models
↓
Service          ← Business logic, uses Entity
↓
Repository        ← JPA inbuilt methods + Proxy Class
↓
Database         ← MySQL (JPAEMS)

---

## 📡 API Endpoints

### Base URL: `http://localhost:8080/employee`

| Method | Endpoint | Description |
|---|---|---|
| GET | `/check` | Check if server is running |
| POST | `/add` | Add a new employee |
| POST | `/add/all` | Add multiple employees |
| GET | `/all` | Get all employees |
| GET | `/id/{id}` | Get employee by ID |
| GET | `/dept/{department}` | Get employees by department |
| PUT | `/update/{id}` | Update employee details |
| DELETE | `/delete/{id}` | Delete employee by ID |
| DELETE | `/delete/all` | Delete all employees |

---

## 📝 Sample Request & Response

### ➕ Add Employee
**POST** `/employee/add`

Request Body:
```json
{
    "name": "Raju",
    "department": "HR",
    "salary": 32000.0
}
```

Response:
```json
{
    "id": 1,
    "name": "Raju"
}
```

---

### 📋 Get All Employees
**GET** `/employee/all`

Response:
```json
[
    {
        "id": 1,
        "name": "Raju",
        "department": "HR",
        "salary": 32000.0
    },
    {
        "id": 2,
        "name": "Priya",
        "department": "IT",
        "salary": 45000.0
    }
]
```

---

### ✏️ Update Employee
**PUT** `/employee/update/1`

Request Body:
```json
{
    "name": "Raju Kumar",
    "department": "Finance",
    "salary": 40000.0
}
```

---

### ❌ Delete Employee
**DELETE** `/employee/delete/1`

Response:
```json
{
    "status": "Employee has been deleted"
}
```

---

## 🗄️ Database

- **Database Name:** `JPAEMS`
- **Table:** `employee` (auto-created by Hibernate)
- **Columns:** `id`, `name`, `department`, `salary`

---

## 👨‍💻 Author

- **Name:** Narendra
- **Project:** EmployeeManagementSystem
- **Package:** pcodes.jpaproject.EMS
- **Learning:** Spring Boot, JPA, REST APIs
