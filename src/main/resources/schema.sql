CREATE TABLE IF NOT EXISTS users (
    id VARCHAR(64) PRIMARY KEY,
    email VARCHAR(25),
    city VARCHAR(25),
    cart VARCHAR(64),
    wishList VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS things (
    id VARCHAR(64) PRIMARY KEY,
    name VARCHAR(25),
    price FLOAT,
    image VARCHAR(64),
    description VARCHAR(255),
    `is` BIT,
    quantity INT
);

CREATE TABLE IF NOT EXISTS cart (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(64),
    thing_id VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS wishlist (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(64),
    thing_id VARCHAR(64)
);

