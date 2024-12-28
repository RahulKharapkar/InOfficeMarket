# InOffice Marketplace: An In-House Trading Platform for Employees

The InOffice Marketplace is a Spring Boot application that provides a platform for employees within an organization to buy, sell, or trade goods and services with each other.

This application allows employees to create offers, submit requirements, and make proposals, fostering a collaborative and efficient in-house marketplace. It leverages Spring Boot's robust features to provide a secure, scalable, and user-friendly experience.

## Repository Structure

```
.
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── rk
│   │   │           └── iom
│   │   │               ├── config
│   │   │               ├── controller
│   │   │               ├── exception
│   │   │               ├── model
│   │   │               ├── repository
│   │   │               ├── service
│   │   │               └── util
│   │   └── resources
│   └── test
│       └── java
│           └── com
│               └── rk
│                   └── iom
│                       ├── controller
│                       ├── service
│                       └── test
```

### Key Files:
- `pom.xml`: Maven project configuration file
- `src/main/java/com/rk/iom/InOfficeMarketApplication.java`: Main application entry point
- `src/main/java/com/rk/iom/config/SecurityConfig.java`: Security configuration
- `src/main/java/com/rk/iom/config/JasyptEncryptorConfig.java`: Encryption configuration
- `src/main/resources/application.yml`: Main application configuration
- `src/main/resources/application-dev.yml`: Development environment configuration
- `src/main/resources/application-local.yml`: Local environment configuration

## Usage Instructions

### Installation

Prerequisites:
- Java 17 or later
- Maven 3.6 or later
- MySQL 8.0 or later

Steps:
1. Clone the repository:
   ```
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```
   cd InOfficeMarket
   ```
3. Build the project:
   ```
   mvn clean install
   ```

### Configuration

1. Set up your database connection in `src/main/resources/application-dev.yml` or `src/main/resources/application-local.yml` depending on your environment.

2. Configure the Jasypt encryption key in `src/main/java/com/rk/iom/config/JasyptEncryptorConfig.java`:
   ```java
   config.setPassword("your-encryption-key");
   ```

### Running the Application

To run the application locally:

```
mvn spring-boot:run
```

The application will start on `http://localhost:8085` by default.

### API Documentation

Once the application is running, you can access the Swagger UI for API documentation at:

```
http://localhost:8085/swagger-ui/index.html#/
```

### Testing

To run the tests:

```
mvn test
```

### Troubleshooting

1. Database Connection Issues:
   - Ensure your MySQL server is running
   - Verify the database credentials in the application-*.yml files
   - Check the database host and port settings

2. Security Configuration:
   - If you're having authentication issues, review the `SecurityConfig.java` file
   - Ensure you're using the correct credentials when logging in

3. Encryption Issues:
   - Verify the encryption key in `JasyptEncryptorConfig.java`
   - Ensure all encrypted properties in configuration files are properly formatted

## Data Flow

1. User makes a request to the application
2. Request is intercepted by Spring Security for authentication and authorization
3. If authenticated, the request is routed to the appropriate controller
4. Controller calls the corresponding service method
5. Service performs business logic and interacts with repositories as needed
6. Repositories interact with the MySQL database
7. Data flows back through the service and controller
8. Response is sent back to the user

```
[User] <-> [Spring Security] <-> [Controller] <-> [Service] <-> [Repository] <-> [MySQL Database]
```

## Deployment

Prerequisites:
- Java 17 or later installed on the server
- MySQL 8.0 or later installed and configured

Steps:
1. Build the application:
   ```
   mvn clean package
   ```
2. Copy the generated JAR file to your server
3. Set up environment variables for database connection and other sensitive information
4. Run the application:
   ```
   java -jar InOfficeMarket.jar
   ```

Ensure you've properly configured your production environment, including database settings and security measures, before deploying to a live environment.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any queries or suggestions, please contact Rahul Kharapkar at [rahul.p.kharapkar@gmail.com](mailto:rahul.p.kharapkar@gmail.com).

---