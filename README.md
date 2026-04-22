# 💬 Chatting App

A full-stack real-time chatting application built using **React (Frontend)** and **Spring Boot (Backend)**. This project demonstrates modern web development practices including REST APIs, authentication, and scalable architecture.

---

## 🚀 Tech Stack

### 🔹 Frontend

* React
* JavaScript (ES6+)
* HTML5 / CSS3
* Axios

### 🔹 Backend

* Spring Boot
* Java
* REST APIs
* Spring Security (if added)

### 🔹 Database

* MySQL (or any DB you are using)

---

## 📂 Project Structure

```
Chatting App/
├── Backend/        # Spring Boot backend
├── Frontend/       # React frontend
├── .gitignore
├── README.md
```

---

## Run With Docker

```bash
 docker-compose up --build
 ```

Open:

Frontend: http://localhost:3000
Backend: http://localhost:9096

## ⚙️  Manual Setup Instructions

### 🔹 1. Clone the repository

```bash
git clone https://github.com/your-username/chatting-app.git
cd chatting-app
```

---

### 🔹 2. Backend Setup (Spring Boot)

```bash
cd Backend
```

* Configure database in `application.properties`
```
spring.datasource.url=jdbc:postgresql://localhost:5432/chatdb
spring.datasource.username=postgres
spring.datasource.password="YOUR_PASSWORD"
server.port=9096
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.data.redis.host  = localhost
spring.data.redis.port = 6379

```
* Run the application:

```bash
./mvnw spring-boot:run
```

OR run from IDE

---

### 🔹 3. Frontend Setup (React)

```bash
cd Frontend
npm install
npm start
```

App will run on:

```
http://localhost:3000
```

---

## 🔐 Features

* User Authentication (Login / Signup)
* Real-time Messaging (if implemented)
* REST API integration
* Clean UI
* Scalable backend structure

---

## 🧠 Future Improvements

* WebSocket integration for real-time chat
* JWT Authentication
* Docker deployment
* Kubernetes setup
* Message persistence & history
* Notifications

---

## ⚠️ Environment Variables

Create `.env` file in frontend and configure:

```
REACT_APP_API_URL=http://localhost:8080
```

---

## 🤝 Contributing

Contributions are welcome!
Feel free to fork this repo and submit a pull request.

---

## 📜 License

This project is open-source and available under the MIT License.

---

## 👨‍💻 Author

Developed by **Tushar**

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!
