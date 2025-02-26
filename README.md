# Transfer/Account Management API

This project is a Transfer/Account Management API built with Java, Spring Boot, and Maven. It follows the Hexagonal Architecture pattern to ensure a clean separation of concerns.

## Table of Contents

- [Architecture](#architecture)
- [Endpoints](#endpoints)

## Architecture

The project is organized following the Hexagonal Architecture (Ports and Adapters) pattern. The main packages are:

- **domain**: Contains the core business logic and domain entities.
- **application**: Contains the application logic, including use cases and DTOs.
- **infrastructure**: Contains the implementation of the output ports, such as repositories and external services.
- **adapter**: Contains the input and output adapters, such as controllers and API clients.

## Endpoints

The API provides the following endpoints:

- `POST /account`: Save a new account.
- `GET /account/{id}`: List accounts by customerId.
- `GET /account/number/{accountNumber}`: Get account by account number.
- `POST /transfer`: Create a new transfer.
- `GET /transfer/all/{id}`: Get all transfers from an account.
- `GET /transfer/sent/{id}`: Get all sent transfers by an account.
- `GET /transfer/received/{id}`: Get all received transfers by an account.
- `POST /withdrawal`: Make a withdrawal.
- `GET /withdrawal/{accountNumber}`: List withdrawals by account number.
- `POST /deposit`: Make a deposit.
- `GET /deposit/{accountNumber}`: List deposits by account number.


Refer to the `openapi.yaml` file for detailed API specifications.
