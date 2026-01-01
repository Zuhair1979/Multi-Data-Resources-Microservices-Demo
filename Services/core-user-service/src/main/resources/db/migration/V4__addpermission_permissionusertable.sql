CREATE TABLE permission (
    permission_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    permission_desc VARCHAR(200)
);

-- Fixed Typo: "pemission_user" -> "permission_user"
-- Fixed Reference: "user_app" -> "app_user" (to match your previous classes)
CREATE TABLE permission_user (
    permission_id INT NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY (permission_id, user_id),
    CONSTRAINT fk_to_permission FOREIGN KEY (permission_id) REFERENCES permission (permission_id),
    CONSTRAINT fk_to_user FOREIGN KEY (user_id) REFERENCES app_user (user_id)
);