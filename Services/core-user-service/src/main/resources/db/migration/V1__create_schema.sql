-- 1. Identity Table
CREATE TABLE login_info (
    user_name VARCHAR(200) PRIMARY KEY,
    password VARCHAR(200) NOT NULL
);

-- 2. User Table (linked to Login)
CREATE TABLE app_user (
    user_id INT PRIMARY KEY,
    user_name VARCHAR(200) NOT NULL,
    CONSTRAINT fk_user_login FOREIGN KEY (user_name) REFERENCES login_info(user_name)
);

-- 3. Roles Table
CREATE TABLE roles (
    role_id INT PRIMARY KEY,
    role_desc VARCHAR(200) NOT NULL
);

-- 4. Join Table (Many-to-Many)
CREATE TABLE user_roles (
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_to_user FOREIGN KEY (user_id) REFERENCES app_user(user_id),
    CONSTRAINT fk_to_role FOREIGN KEY (role_id) REFERENCES roles(role_id)
);