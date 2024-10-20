# Store Service

### A RESTful API service for managing stores and warehouses, including product inventory and stock management.

## The API provides functionality to:

- Create and manage stores/warehouses
- Search for products across stores
- Add and consume stock for products, with full history tracking

### The system ensures accurate tracking of inventory movements, allowing efficient management of product stock levels across multiple locations.

### Technologies Used: `Java (Spring Boot)`, `MySQL`, `Docker`

## Key Features:

- CRUD operations for Stores, Products, and Categories
- Stock management with historical tracking of stock changes
- Search functionality for products across all stores

## ER Diagram

![Store ERD](https://github.com/user-attachments/assets/d2e26bee-f5e2-418d-9058-fcd3521b8f7a)

## API Documentation

## Create Store

### `POST /store`

Creates a new store with the specified name and location.

### Request

- **Content-Type:** `application/json`
- **Body:**
    ```json
    {
      "name": "string",
      "location": "string"
    }
    ```

  | Field      | Type   | Description                        |
  |------------|--------|------------------------------------|
  | `name`     | string | The name of the store.             |
  | `location` | string | The physical location of the store.|

### Response

#### Success Response

- **Status Code:** `201 Created`
- **Content-Type:** `application/json`
- **Body:**
    ```json
    {
      "id": "Long",
      "name": "string",
      "location": "string"
    }
    ```

  | Field      | Type   | Description                        |
    |------------|--------|------------------------------------|
  | `id`       | Long   | Unique identifier for the store.   |
  | `name`     | string | The name of the store.             |
  | `location` | string | The physical location of the store.|

#### Error Response

- **Status Code:** `400 Bad Request`
- **Content-Type:** `application/json`
- **Body:**
    ```json
    {
      "code": 400,
      "status": "Bad Request",
      "timestamp": "2024-10-21 01:11:59 AM",
      "message": "Store already exists"
    }
    ```
- **Description:** Returned when the input store already exists.

    ```json
    {
      "code": 400,
      "status": "Bad Request",
      "timestamp": "2024-10-21 01:14:02 AM",
      "errors": {
          "name": "Store name required."
      }
    }
    ```
- **Description:** Returned when the input data is missing or invalid.

### Example

#### Request:
```json
{
  "name": "Tech Supplies",
  "location": "123 Main Street, Springfield"
}
```

#### Response:
```json
{
  "id": 1,
  "name": "Tech Supplies",
  "location": "123 Main Street, Springfield"
}
```
