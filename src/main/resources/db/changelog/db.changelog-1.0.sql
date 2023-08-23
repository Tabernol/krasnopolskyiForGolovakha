--liquibase formatted sql

--changeset max:1
    USE golovakha;
    CREATE TABLE IF NOT EXISTS my_number(
        id INT PRIMARY KEY AUTO_INCREMENT,
        count INT
    );

--changeset max:2
    INSERT INTO my_number VALUE (1, 0);