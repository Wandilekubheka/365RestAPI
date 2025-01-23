# Codebase Documentation

This document provides an overview of the codebase, its functionality, and details about the available endpoints.

## Project Description

This application is designed for waste management, allowing users to manage and categorize waste and disposal methods. The application includes endpoints for managing categories and waste items, supporting CRUD operations for both entities.

---

## Endpoints Overview

### 1. **CategoryController**
Manages waste categories, including their names, disposal methods, and recycling tips.

**Base Path**: `/categories`

#### **Endpoints:**

- **GET `/categories`**
    - Retrieves all categories.
    - **Response**: List of `Category` objects.

- **GET `/categories/id/{id}`**
    - Retrieves a category by its ID.
    - **Path Variable**:
        - `id` (int): The ID of the category.
    - **Response**: `Category` object.

- **GET `/categories/name/{name}`**
    - Retrieves a category by its name.
    - **Path Variable**:
        - `name` (String): The name of the category.
    - **Response**: `Category` object.

- **POST `/categories`**
    - Creates a new category.
    - **Request Body**: `Category` object.
    - **Response**: Created `Category` object.

- **PUT `/categories`**
    - Updates an existing category.
    - **Request Body**: `Category` object with updated data.
    - **Response**: Updated `Category` object.

- **DELETE `/categories/{id}`**
    - Deletes a category by its ID.
    - **Path Variable**:
        - `id` (int): The ID of the category.
    - **Response**: No content.

### 2. **WasteController**
Manages waste items, including their descriptions and associated categories.

**Base Path**: `/wastes`

#### **Endpoints:**

- **GET `/wastes`**
    - Retrieves all waste items.
    - **Response**: List of `Waste` objects.

- **GET `/wastes/search/{categoryString}`**
    - Retrieves waste items by category.
    - **Path Variable**:
        - `categoryString` (String): The category of waste.
    - **Response**: List of `Waste` objects.

- **GET `/wastes/{id}`**
    - Retrieves a waste item by its ID.
    - **Path Variable**:
        - `id` (int): The ID of the waste item.
    - **Response**: `Waste` object.

- **POST `/wastes`**
    - Adds a new waste item.
    - **Request Body**: `Waste` object.
    - **Response**: Created `Waste` object.

- **PUT `/wastes`**
    - Updates an existing waste item.
    - **Request Body**: `Waste` object with updated data.
    - **Response**: Updated `Waste` object.

- **DELETE `/wastes`**
    - Deletes a waste item.
    - **Request Body**: `Waste` object to delete.
    - **Response**: Deleted `Waste` object.

---

## Data Models

### 1. **Category**
Represents a waste category with associated metadata.

```java
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(nullable = false, length = 50)
    private String categoryName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String disposalMethod;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String recycleTips;

    // Getters and Setters
}
```

### 2. **Waste**
Represents a waste item with details such as category and description.

```java
@Entity
public class Waste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;
    private String description;

    // Getters and Setters
}
```

---

## How to Use

1. **Setup**
    - Clone the repository.
    - Build the project using Maven.
    - Run the application with `./mvnw spring-boot:run`.

2. **Access API**
    - Base URL: `http://localhost:8080`
    - Use tools like Postman or cURL to interact with the endpoints.

---
