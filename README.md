# Todo App

A simple Todo application built with Maven, Spring Boot 3.4.10, and Java 21.

## Features

- Create a new task
- Get a single task by ID
- Get all tasks
- Update an existing task
- Delete a task

## Branches

- `main`: Stable production-ready version
- `develop`: Active development branch

## Tech Stack

- Java 21
- Spring Boot 3.4.10
- Maven

## Getting Started

### Prerequisites

- Java 21 or later
- Maven

### Build and Run

1. Clone the repository:
    ```sh
    git clone https://github.com/bejoy-gokul/Todo.git
    cd Todo
    ```

2. Switch to the desired branch (`main` or `develop`):
    ```sh
    git checkout develop
    ```

3. Build the project:
    ```sh
    mvn clean install
    ```

4. Run the application:
    ```sh
    mvn spring-boot:run
    ```

### API Endpoints

| Method | Endpoint          | Description             |
|--------|-------------------|-------------------------|
| POST   | `/todo`           | Create a new task       |
| GET    | `/todo?id`        | Get a task by ID        |
| GET    | `/todo/all`       | Get all tasks           |
| PUT    | `/todo`           | Update a task           |
| DELETE | `/todo?id`        | Delete a task           |

## Contributing

Feel free to fork the repository and submit pull requests. For major changes, open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License.
