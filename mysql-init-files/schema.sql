CREATE DATABASE IF NOT EXISTS transfers
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE transfers;

CREATE TABLE IF NOT EXISTS transfer_type (
    id BIGINT UNSIGNED PRIMARY KEY,
    name VARCHAR(255) NOT NULL
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS account (
    id BIGINT UNSIGNED PRIMARY KEY,
    account_number VARCHAR(255) NOT NULL,
    account_password VARCHAR(255) NOT NULL,
    balance DOUBLE NOT NULL,
    customer_id BIGINT NOT NULL
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS transfer (
    id BIGINT UNSIGNED PRIMARY KEY,
    amount DOUBLE NOT NULL,
    transfer_date DATE NOT NULL,
    sender_id BIGINT NOT NULL,
    receiver_id BIGINT NOT NULL,
    transfer_type_id BIGINT NOT NULL,
    FOREIGN KEY (sender_id) REFERENCES account(id),
    FOREIGN KEY (receiver_id) REFERENCES account(id),
    FOREIGN KEY (transfer_type_id) REFERENCES transfer_type(id)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS account_deposit (
    id BIGINT UNSIGNED PRIMARY KEY,
    amount DOUBLE NOT NULL,
    deposit_date DATE NOT NULL,
    account_id BIGINT NOT NULL,
    FOREIGN KEY (account_id) REFERENCES account(id)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS account_withdrawal (
    id BIGINT UNSIGNED PRIMARY KEY,
    amount DOUBLE NOT NULL,
    withdrawal_date DATE NOT NULL,
    account_id BIGINT NOT NULL,
    FOREIGN KEY (account_id) REFERENCES account(id)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

INSERT INTO transfer_type(id, name) VALUES (1, 'PIX');
INSERT INTO transfer_type(id, name) VALUES (2, 'Crédito');
INSERT INTO transfer_type(id, name) VALUES (3, 'Débito');
INSERT INTO transfer_type(id, name) VALUES (4, 'Boleto');

INSERT INTO account(id, account_number, account_password, balance, customer_id) VALUES (1, '1234', '123', 100.5, 1);
INSERT INTO account(id, account_number, account_password, balance, customer_id) VALUES (2, '2345', '123', 100.0, 1);
INSERT INTO account(id, account_number, account_password, balance, customer_id) VALUES (3, '7235', '123', 120.5, 2);
INSERT INTO account(id, account_number, account_password, balance, customer_id) VALUES (4, '9334', '123', 150.5, 3);
INSERT INTO account(id, account_number, account_password, balance, customer_id) VALUES (5, '7224', '123', 50, 4);
INSERT INTO account(id, account_number, account_password, balance, customer_id) VALUES (6, '5244', '123', 0.5, 5);
INSERT INTO account(id, account_number, account_password, balance, customer_id) VALUES (7, '8231', '123', 0, 6);
INSERT INTO account(id, account_number, account_password, balance, customer_id) VALUES (8, '8531', '123', 10, 7);

INSERT INTO account_deposit(id, amount, deposit_date, account_id) VALUES (1, 100.5, '2021-10-10', 1);
INSERT INTO account_withdrawal(id, amount, withdrawal_date, account_id) VALUES (2, 150, '2021-10-10', 7);

INSERT INTO transfer(id, amount, transfer_date, sender_id, received_id, transfer_type_id) VALUES (1, 100.5, '2021-10-10', 1, 2, 1);