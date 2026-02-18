# Premium E-Commerce Web Application

A full-featured, end-to-end e-commerce platform built with **Java**, **Spring Boot**, **Thymeleaf**, and **MySQL**. This application features a modern responsive UI, user authentication, product management, and a complete shopping flow.

## 🚀 Features

### User End
*   **Modern UI:** Responsive design using pure CSS and glassmorphism effects.
*   **Authentication:** User registration and login functionality.
*   **Product Browsing:** View products by categories, search functionality, and detailed product views.
*   **Shopping Cart:** Add/remove items, update quantities, and persistent cart management.
*   **Order System:** Simplified checkout process and order history tracking.

### Admin End
*   **Product Management:** Add, Update, and Delete products.
*   **Category Management:** Organize products into logical categories.
*   **Image Handling:** Integrated support for product images.

## 🛠️ Tech Stack

*   **Backend:** Java 17+, Spring Boot 3.x, Spring Data JPA, Hibernate.
*   **Frontend:** Thymeleaf Template Engine, HTML5, CSS3.
*   **Database:** MySQL.
*   **Build Tool:** Maven.
*   **Utilities:** Lombok, Spring Validation.

## 📋 Prerequisites

*   **JDK 17 or higher**
*   **Maven 3.6+**
*   **MySQL Server 8.0+**
*   **IDE** (IntelliJ IDEA, STS, or Eclipse)

## ⚙️ Setup & Installation

1.  **Clone the Repository**
    ```bash
    git clone https://github.com/your-username/ecommerce-spring-boot.git
    cd ecommerce-spring-boot
    ```

2.  **Database Configuration**
    *   Create a MySQL database named `ecommerce_db`.
    *   Open `src/main/resources/application.properties` and update your MySQL credentials:
        ```properties
        spring.datasource.username=your_username
        spring.datasource.password=your_password
        ```

3.  **Automatic Schema & Data Loading**
    The application is configured to automatically create tables and load sample data on first run using `schema.sql` and `data.sql`.
    *   `spring.sql.init.mode=always` ensures scripts run on startup.

4.  **Build and Run**
    Using Maven:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```
    Or run `EcommerceApplication.java` directly from your IDE.

5.  **Access the Application**
    *   Open your browser and navigate to: `http://localhost:8081`

## 👤 Sample Credentials

| Role | Email | Password |
| :--- | :--- | :--- |
| **Admin** | `admin@example.com` | `123456` |
| **User** | `user@example.com` | `123456` |

## 📂 Project Structure

*   `src/main/java/.../entity`: JPA Database Entities.
*   `src/main/java/.../repository`: Data Access Layer.
*   `src/main/java/.../service`: Business Logic Layer.
*   `src/main/java/.../controller`: Web Controllers for routing.
*   `src/main/resources/templates`: Thymeleaf HTML views.
*   `src/main/resources/static`: CSS, JS, and local images.
*   `src/main/resources/schema.sql`: Database table definitions.
*   `src/main/resources/data.sql`: Initial sample data and categories.

---
Developed with ❤️ by Madhu
