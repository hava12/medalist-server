CREATE TABLE user (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(255) NOT NULL,
      email VARCHAR(255),
      mobile_number VARCHAR(255)
);

CREATE TABLE competition (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     category VARCHAR(10) NOT NULL,
     location VARCHAR(255) NOT NULL,
     start_datetime DATETIME,
     end_datetime DATETIME,
     registration_deadline DATETIME,
     min_participants BIGINT,
     max_participants BIGINT,
     status VARCHAR(10) NOT NULL
);

CREATE TABLE registration (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     user_id BIGINT,
     competition_id BIGINT,
     status VARCHAR(10) NOT NULL,
     FOREIGN KEY (competition_id) REFERENCES competition(id),
     FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE records (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     user_id BIGINT,
     competition_id BIGINT,
     ranking INT,
     score INT,
     comment VARCHAR(200),
     FOREIGN KEY (competition_id) REFERENCES competition(id),
     FOREIGN KEY (user_id) REFERENCES user(id)
);
