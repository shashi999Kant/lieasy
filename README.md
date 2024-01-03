# Spring Boot Project with PostgreSQL

This project is a simple Spring Boot application with PostgreSQL integration, providing RESTful APIs for managing loads and associated shippers.

## Features

- Create, read, update, and delete loads
- Retrieve a list of loads associated with a specific shipper
- Integration with PostgreSQL database
- Many-to-One relationship between `Load` and `Shipper` entities

## Technologies Used

- Java
- Spring Boot
- PostgreSQL
- Hibernate (JPA)
- Maven

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven
- PostgreSQL database

### Configuration

1. Clone the repository:

   ```bash
   git clone <repository-url>
   ```

2. Set up your PostgreSQL database and update the `application.properties` file with your database configuration.

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.datasource.driver-class-name=org.postgresql.Driver
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Run the application:

   ```bash
   mvn spring-boot:run
   ```

4. Access the APIs at `http://localhost:8080/loads`.

## API Endpoints

1. **POST `/loads/load`**

   Add a new load. Example payload:

   ```json
   {
     "loadingPoint": "delhi",
     "unloadingPoint": "jaipur",
     "productType": "chemicals",
     "truckType": "canter",
     "noOfTrucks": 1,
     "weight": 100,
     "comment": "",
     "date": "dd-mm-yyyy",
     "shipper": {
       "id": 1
     }
   }
   ```

2. **GET `/loads?shipperId={shipperId}`**

   Retrieve a list of loads associated with a specific shipper.

3. **GET `/loads/load/{loadId}`**

   Retrieve details of a specific load by ID.

4. **PUT `/loads/load/{loadId}`**

   Update details of a specific load by ID. Example payload:

   ```json
   {
     "loadingPoint": "alwar",
     "unloadingPoint": "jaipur",
     "productType": "chemicals",
     "truckType": "canter",
     "noOfTrucks": 1,
     "weight": 100,
     "comment": "",
     "date": "dd-mm-yyyy"
   }
   ```

5. **DELETE `/loads/load/{loadId}`**

   Delete a specific load by ID.

## Contributing

Feel free to contribute to this project by opening issues or submitting pull requests. Your contributions are always welcome!

## License

This project is licensed under the [MIT License](LICENSE).
