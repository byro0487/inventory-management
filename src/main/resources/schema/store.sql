CREATE TABLE store (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    area DOUBLE NOT NULL,
    status VARCHAR(50),
    location_id VARCHAR(255),
    manager_id VARCHAR(255),
    inventory_id VARCHAR(255),
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
