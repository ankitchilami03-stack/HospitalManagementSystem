# 🏥 Hospital Management System

## 📌 Project Description

This is a web-based Hospital Management System developed using **Angular** for the frontend and **Spring Boot (Spring Data JPA with Hibernate)** for the backend.

The system is **Admin-driven**, where the Admin manages patients, doctors, and appointments. Doctors can view assigned appointments and patient details.

---

## 🚀 Modules

### 👨‍💼 Admin Module

* Admin login
* Add and manage patients
* Add and manage doctors
* Create appointments
* Assign appointments to doctors
* Manage appointment records

### 👨‍⚕️ Doctor Module

* Doctor login
* View assigned appointments
* View patient details

### 📅 Appointment Module

* Create appointments by Admin
* Assign doctor to patient
* Update and manage appointments
* View appointment list

---

## 🛠️ Tech Stack

### Frontend

* Angular
* HTML
* CSS
* TypeScript

### Backend

* Spring Boot
* Spring Data JPA (Hibernate ORM)
* REST APIs

### Database

* MySQL

---

## ⚙️ Features

* Role-based access (Admin & Doctor)
* Patient and doctor management
* Appointment scheduling system
* REST API integration between frontend and backend
* CRUD operations using JPA/Hibernate

---

## 📂 Project Structure

### Frontend (Angular)

* Admin Login Component
* Doctor Login Component
* Admin Dashboard Component
* Services for API communication

### Backend (Spring Boot)

* Entity Classes (Patient, Doctor, Appointment)
* Repository Layer (JPA)
* Service Layer
* Controller Layer (REST APIs)

---

## 🔧 Setup Instructions

### ▶️ Frontend (Angular)

```bash id="a1"
npm install
ng serve
```

Application runs at:

```
http://localhost:4200
```

---

### ▶️ Backend (Spring Boot)

```bash id="a2"
mvn spring-boot:run
```

Server runs at:

```
http://localhost:8080
```

---

## 🗄️ Database Configuration

Update `application.properties`:

```properties id="a3"
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

---

## 📸 Screenshots

(Add your project screenshots here like login, dashboard, etc.)

---

## 🔮 Future Enhancements

* Patient self-registration module
* Online appointment booking
* Prescription management system
* Billing and payment module
* Lab and diagnostic reports
* Pharmacy management system
* Reports and analytics dashboard

---

## 👤 Author

* Ankit Chilami

---

## 📌 Note

This is a mini Hospital Management System focused on Admin and Doctor modules. It demonstrates full-stack development using Angular and Spring Boot with database integration using JPA (Hibernate).
