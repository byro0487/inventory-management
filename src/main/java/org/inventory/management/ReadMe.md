# Inventory Management:
### Service Architecture Overview

Our service is built as a gRPC server instead of a traditional REST controller to take advantage of the HTTP/2 protocol and Protocol Buffers (protobuf) for efficient communication and serialization.

### Proto Contracts

The service contracts are defined in three separate protobuf files:

- [InventoryManagementService.proto](..%2F..%2F..%2F..%2Fproto%2FInventoryManagementService.proto)
- [ProductManagementService.proto](..%2F..%2F..%2F..%2Fproto%2FProductManagementService.proto)
- [StoreManagementService.proto](..%2F..%2F..%2F..%2Fproto%2FStoreManagementService.proto)

### Authentication and Authorization

We have implemented authentication and authorization using JWT tokens. This is handled by a server interceptor, which ensures that only authenticated and authorized requests are processed by the server.

### Database

For the time being, we are using H2 as our RDBMS. However, this can be easily replaced by PostgreSQL in a production environment.

### Code Comments

We have added comments to each important class and method to ensure easy understanding and maintainability of the codebase.
### Steps to Test:

1. **Run the Application**: Start the gRPC server by running the `main` method. You can execute it as you would a simple Java application.

2. **Use [BloomRPC](https://github.com/bloomrpc/bloomrpc/releases) as Client**: Instead of Postman, utilize BloomRPC as the client for making gRPC requests. Import the proto files into BloomRPC and include the "Authorization" header with the JWT token value in the metadata to authenticate and authorize requests.

3. **Use Auth Service for JWT Tokens**: We have included a dummy auth service that provides JWT tokens. You can utilize this service by referencing the `AuthService.proto` file.

## Low Level Design approach :

## Entities:

- Guest
- Admin
- StoreManager
- StoreWorker
- System
- Supplier

---

## Requirements/ Use case diagrams:

### Guest:

- checkEmail()
- login()
- signup()

### StoreWorker:

- checkEmail()
- login()
- signup()
- updateInventory()
- viewInventory()

### StoreManager:

- checkEmail()
- login()
- signup()
- addProduct()
- updateInventory()
- viewInventory()
- restockInventory()

### Admin:

- checkEmail()
- login()
- signup()
- addStore()
- (additional) addProduct()
- (additional) updateInventory()
- (additional) viewInventory()
- (additional) restockInventory()

### System:

- sendNotifications()

### Supplier:

- (additional requirement) provideProductDetails()

---

## Class:

- Store
- Product
- ProductItem
- Rack
- StoreManager
- Admin
- Person
- Inventory

---

## Service Level Classes:

- InventoryManager
- StoreManager
- RestockingManager
- ProductManager

---

## DB:

- RDBMS vs NoSQL
    - Scale is very high - NoSQL
    - Consistency - Strong consistency is needed - RDBMS
    - Type of data - Connections across data - RDBMS

---

## Tables:

- Stores (with `inventoryId` and `storeManagerId` as foreign keys - many stores to 1 inventory)
- Products
- stores_products (many-to-many relationship as any store can have any product)
- StoreTransactions
- ProductItems (`productId` as foreign key, `rackId` as foreign key)
- Racks (`storeId` as foreign key)
- Users (have role as user)

---

## User Activity Diagram:

### login():

1. User sends request with credentials.
2. First authenticate - if we are having the token info as part of request.
    - If no, return 401 saying unauthorized.
    - If yes, check if the user exists.
        - If no, return error saying invalid credentials.
        - If yes, create a token with permissions set.

### checkEmail():

- Check email - if already registered or not.
    - If already registered, return error saying user exists.

### signup():

- Get all the details required such as name, email, password, etc.
- Validate request and if any error, send 400.
- Else, check for password validation.
    - If not okay, send 400.
- Else, create an entry in the DB and return 201.

### addStore:

- Check for user permission.
- Validate input.
    - If exists, return error.
- Add to DB and return.

### addProduct:

- Check for user permissions.
- Get product details.
- Validate input.
    - If already exists, return error.
- Add to DB and return.

### updateInventory():

- Get product id, storeId, quantity, operationType (decrement/increment).
- If any of the above missing, return 400 bad request.
- Get the details for the product and the store.
- Check if the productId is valid, if not and this is a new product, show error saying this product needs to be added first and then updated. Please contact storeManager/admin.
- If productId is valid, and operation type increment:
    - Bonus: Add check for max items that can be added.
    - Take lock on productId, increment (for handling concurrency). Have retry mechanism with exponential backoff.
- If operation type decrement, check if currQuantity >= givenQuantity:
    - If no, then return 400.
    - Else, decrement and update by taking lock.

### viewInventory():

- Get product id, storeId.
- If any of the above missing, return 400 bad request.
- Read from DB.
- Return response (no need for pagination as it will always be a single entry).

### restockInventory():

- We should have an algorithm for restocking.
- For each store, go through the products which have less quantity than threshold. This threshold can be specific for product or per product type.
- Add them to inventory.
- Check the top products which got sold in the store (based on that add more inventory).
- Add items according to expiry for product category (two options: we can calculate this when this method is called, or precompute for each order by asynchronously processing each data).
- This can be triggered via scheduler.

---

## Design Patterns:

- Singleton for configurations file.
- Strategy for restockAlgorithm.
- Factory Method for creating Managers and restockAlgorithms.
- Builder for creating objects.
- Use association for structuring managers.

## Few Other points which are not considered:
- Inward register
- Outward register
- Invoice management
- stock return reason and details

