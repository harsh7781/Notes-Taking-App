# 📝 Notes-Taking-App

A simple, lightweight **Spring Boot MVC** web application designed to help users manage their daily notes efficiently. This project demonstrates a full-stack implementation using the Spring ecosystem with a PostgreSQL backend.

---

## 🚀 Features

* **User Authentication:** Secure login and registration powered by **Spring Security**.
* **CRUD Operations:** Create, Read, Update, and Delete notes.
* **Responsive UI:** A clean interface built with **Thymeleaf** and **Bootstrap**.
* **Persistent Storage:** All data is stored securely in a **PostgreSQL** database.

---

## 🛠️ Tech Stack

### Backend
* **Java 17+**
* **Spring Boot**: Core framework.
* **Spring MVC**: Web layer architecture.
* **Spring Data JPA**: Database abstraction and ORM.
* **Spring Security**: Authentication and Authorization.

### Frontend
* **Thymeleaf**: Server-side template engine.
* **HTML5 / CSS3**: Structure and styling.

### Database
* **PostgreSQL**: Relational database management.

---

## ⚙️ Getting Started

### Prerequisites
* [JDK 17 or higher](https://www.oracle.com/java/technologies/downloads/)
* [Maven](https://maven.apache.org/download.cgi)
* [PostgreSQL](https://www.postgresql.org/download/)

### Installation & Setup

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/harsh7781/Notes-Taking-App.git](https://github.com/harsh7781/Notes-Taking-App.git)
    cd Notes-Taking-App
    ```

2.  **Configure the Database:**
    * Create a database named `notes_db` in PostgreSQL.
    * Navigate to `src/main/resources/application.properties`.
    * Update the following credentials:
        ```properties
        spring.datasource.url=jdbc:postgresql://localhost:5432/notes_db
        spring.datasource.username=your_postgres_username
        spring.datasource.password=your_postgres_password
        spring.jpa.hibernate.ddl-auto=update
        ```

3.  **Build and Run:**
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

4.  **Access the Application:**
    Open your browser and go to: `http://localhost:8080`

---

## 📁 Project Structure
```text
Notes-Taking-App/
├── src/
│   ├── main/
│   │   ├── java/        # Backend logic (Controllers, Models, Services)
│   │   └── resources/
│   │       ├── templates/ # Thymeleaf HTML files
│   │       ├── static/    # CSS and JS
│   │       └── application.properties # Configurations
└── pom.xml               # Project dependencies
```

---

## Contributing
Contributions are welcome! If you'd like to improve the app:
* Fork the repository.
* Create a feature branch (git checkout -b feature/NewFeature).
* Commit your changes (git commit -m 'Add NewFeature').
* Push to the branch (git push origin feature/NewFeature).
* Open a Pull Request.
