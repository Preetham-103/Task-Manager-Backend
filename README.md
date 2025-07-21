
# ✅ Task Manager Backend API

A robust and scalable Task Management Backend system built using **Spring Boot**. This RESTful service allows users to **create, read, update, and delete (CRUD)** their daily tasks, with support for task statuses and due dates.

---

## 🚀 Features

- 🗂️ Full CRUD operations for Tasks
- 📆 Task due date tracking
- 📌 Task status management: `Pending`, `Completed`, etc.
- 📦 JSON-based clean RESTful responses
- 🛠️ Ready to integrate with any Frontend (React, Angular, etc.)

---

## 🛠️ Tech Stack

| Layer            | Tech Used               |
|------------------|-------------------------|
| Language         | Java                    |
| Framework        | Spring Boot             |
| Dependency Mgmt  | Maven                   |
| API Framework    | Spring Web (REST)       |
| Data Persistence | Spring Data JPA         |
| Database         | MySQL                   |
| Others           | Lombok, ModelMapper     |

---

## 🔗 API Endpoints

| Method | Endpoint           | Description            |
|--------|--------------------|------------------------|
| GET    | `/api/tasks`       | Fetch all tasks        |
| POST   | `/api/tasks`       | Create a new task      |
| PUT    | `/api/tasks/{id}`  | Update an existing task|
| DELETE | `/api/tasks/{id}`  | Delete a task by ID    |

---

## ⚙️ How to Run Locally

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/task-manager-backend.git
   cd task-manager-backend
   ```

2. **Configure MySQL**
   - Create a database named `taskmanager`
   - Update `application.properties` with your DB credentials:
     ```properties
     spring.datasource.username=yourUsername
     spring.datasource.password=yourPassword
     ```

3. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

4. Backend will run at: `http://localhost:8080`

---

## 🧪 Testing the API

Use tools like **Postman** or **cURL** to test API endpoints.

You can also import this [Postman Collection](#) (if available).

---

## 📁 Project Structure

```
src
├── controller       # REST Controllers
├── model            # Entity classes
├── repository       # JPA Repositories
├── service          # Business Logic
└── dto              # Data Transfer Objects
```

---

## 📸 Screenshots

_Add screenshots or Postman results here if available_
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/d58b9af1-5345-4a34-bf0c-acfe4cd7e0d5" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/9430b187-4d9e-414c-964b-e09845cada6c" />

---

## 📝 License

This project is licensed under the **MIT License** - feel free to use and modify it.

---

## 🤝 Let's Connect!

If you liked this project or want to collaborate:
- Connect with me on [LinkedIn](https://www.linkedin.com/in/preethamdundigalla)
- ⭐ Star this repo to support it!

---

> _“Plan your work and work your plan – this app helps you do just that.”_
