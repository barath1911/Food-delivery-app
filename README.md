# 🍔 Food Delivery Backend API

A **Spring Boot REST API** for a Food Delivery System that supports **user authentication, restaurant management, food menu management, order processing, payments, and delivery tracking**.

This project demonstrates **secure backend architecture, REST API design, JWT authentication, validation, and layered architecture**.

---

# 🚀 Features

* User Registration & Login with **JWT Authentication**
* Role-Based Authorization (**USER, OWNER, DELIVERY, ADMIN**)
* Restaurant Management
* Food Menu Management
* Order Creation with Multiple Items
* Stock Management
* Payment Processing
* Delivery Assignment & Completion
* Global Exception Handling
* Input Validation
* Secure Password Encryption (**BCrypt**)

---

# 🏗️ Tech Stack

* **Java 17**
* **Spring Boot**
* **Spring Security**
* **Spring Data JPA**
* **JWT Authentication**
* **Hibernate**
* **MySQL**
* **ModelMapper**
* **Maven**

---

# 📂 Project Structure

```
food-delivery-app
│
├── controller
│   ├── UserController
│   ├── RestaurantController
│   ├── FoodmenuController
│   ├── OrderController
│   ├── PaymentController
│   └── DeliveryController
│
├── service
│   ├── UserService
│   ├── RestaurantService
│   ├── FoodmenuService
│   ├── OrderService
│   ├── PaymentService
│   └── DeliveryService
│
├── repository
│
├── entity
│
├── dto
│
├── security
│
├── config
│
└── exception
```

---

# 🔐 Authentication

The application uses **JWT (JSON Web Token)** for authentication.

After login, the server returns a token.

Example:

```
Authorization: Bearer <your_token>
```

---

# 👥 User Roles

| Role     | Permissions                    |
| -------- | ------------------------------ |
| USER     | Create orders, make payments   |
| OWNER    | Manage restaurants & food menu |
| DELIVERY | Handle delivery                |
| ADMIN    | Full system access             |

---

# 📌 API Endpoints

## User APIs

```
POST /api/users/register
POST /api/users/login
```

## Restaurant APIs

```
GET /restaurants
POST /restaurants
DELETE /restaurants/{id}
```

## Food Menu APIs

```
GET /foodmenu
POST /foodmenu
PUT /foodmenu/updateStock/{id}
DELETE /foodmenu/delete/{id}
```

## Order APIs

```
POST /orders
```

## Payment APIs

```
POST /payment/pay
```

## Delivery APIs

```
POST /delivery/assign
POST /delivery/delivered
```

---

# 📦 Example Order Request

```json
{
  "customerName": "Barath",
  "customerEmail": "barath@email.com",
  "deliveryLocation": "Chennai",
  "restaurantName": "Pizza Hut",
  "items": [
    {
      "foodMenuId": 1,
      "quantity": 2
    }
  ]
}
```

---

# ⚙️ Setup Instructions

### 1 Clone Repository

```
git clone https://github.com/your-username/food-delivery-app.git
```

### 2 Navigate to Project

```
cd food-delivery-app
```

### 3 Configure Database

Update `application.properties`

```
spring.datasource.url=jdbc:mysql://localhost:3306/food_delivery
spring.datasource.username=root
spring.datasource.password=password
```

### 4 Run Application

```
mvn spring-boot:run
```

---

# 🛡️ Security

* Passwords encrypted using **BCrypt**
* Authentication handled via **JWT**
* Role-based authorization implemented with **Spring Security**

---

# 📈 Future Improvements

* Add **Swagger API Documentation**
* Implement **Pagination**
* Add **Caching with Redis**
* Add **Docker Deployment**
* Convert to **Microservices Architecture**

---

# 👨‍💻 Author

**Barath**

Backend Developer | Java | Spring Boot

---

# ⭐ Support

If you like this project, give it a ⭐ on GitHub!
