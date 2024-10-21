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

### `POST /stores`

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

---

### `POST /stores/add-stock`

Add a new stock item to the store's inventory.

### Request

- **Content-Type:** `application/json`
- **Body:**
    ```json
    {
      "storeId": "Long",
      "productId": "Long",
      "quantity": "Long"
    }
    ```

  | Field       | Type | Description            |
    |-------------|------|------------------------|
  | `storeId`   | Long | The ID of the store.   |
  | `productId` | Long | The ID of the product. |
  | `quantity`  | Long | The quantity of stock to add.|

### Response

#### Success Response

- **Status Code:** `200 Success`
- **Content-Type:** `application/json`
 **Body:**
    ```json
    {
      "id": "Long",
      "storeId": "Long",
      "productId": "Long",
      "quantity": "Long"
    }
    ```

  | Field       | Type | Description                      |
      |-------------|------|----------------------------------|
  | `id`        | Long | Unique identifier for the stock. |
  | `storeId`   | Long | The ID of the store.             |
  | `productId` | Long | The ID of the store.             |
  | `quantity`  | Long | The quantity of stock to add.|

#### Error Response

- **Status Code:** `400 Bad Request`
- **Content-Type:** `application/json`
- **Body:**
    ```json
    {
      "code": 400,
      "status": "Bad Request",
      "timestamp": "2024-10-21 03:28:03 PM",
      "message": "Store not found"
    }
    ```
- **Description:** Returned when the input store doesn't exist.

    ```json
    {
      "code": 400,
      "status": "Bad Request",
      "timestamp": "2024-10-21 03:28:45 PM",
      "errors": {
          "storeId": "Store id is required"
      }
    }
    ```
- **Description:** Returned when the input data is missing or invalid.

### Example

#### Request:
```json
{
  "storeId": 1,
  "productId": 548,
  "quantity": 25
}
```

#### Response:
```json
{
  "id": 2,
  "storeId": 1,
  "productId": 548,
  "quantity": 25
}
```

---

