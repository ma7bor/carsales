**Garage Car Sales API**

Welcome to the Garage Car Sales API, a Spring Boot project that powers a car sales garage. This API exposes four essential services for managing and listing cars in the garage catalog.

Project Description
You have a car sales garage with specific requirements:

1. Add a car to the garage catalog.
2. Display cars by Fuel type and Max Price.
3. List all available car makes in the catalog.
4. Update a car's picture.

**Car Definition**

A car in this catalog is defined by the following attributes:

* Make
* Model
* Registration date
* Price
* Fuel type (DIESEL / ELECTRIC / HYBRID)
* Mileage
* Transmission (MANUAL / SEMI AUTOMATIC / AUTOMATIC)
* Picture 

Note: Only cars registered after 2015 can be added to the catalog.

**API Endpoints**

Add a Car
* Endpoint: /cars
* Method: POST
* Description: Add a new car to the catalog.
* Request Body: Car object with attributes (Make, Model, RegistrationDate, Price, FuelType, Mileage, Transmission, Picture)
* Response: HTTP Status 201 (Created) and a success message.

**Get Cars by Fuel Type and Max Price**
* Endpoint: /cars
* Method: GET
* Description: Get cars filtered by Fuel type and Max Price.
* Query Parameters:
* fuelType (DIESEL / ELECTRIC / HYBRID)
* maxPrice (Double value)
* Response: HTTP Status 200 (OK) and a list of CarDto objects.

**Get All Car Makes**

* Endpoint: /cars/make
* Method: GET
* Description: Get a list of all available car makes in the catalog.
* Response: HTTP Status 200 (OK) and a list of car make names (Strings).
* Update Car Picture
* Endpoint: /cars/{id}/picture
* Method: PUT
* Description: Update a car's picture by its ID.
* Path Parameter: id (Long)
* Query Parameter: pictureUrl (String)
* Response: HTTP Status 200 (OK) and a success message. 

**Project Features**
* Git Repository: This project is hosted on a Git repository for version control.

* Tests: The codebase includes comprehensive unit and integration tests to ensure functionality and reliability.

* Swagger Documentation: The API is documented using Swagger annotations, making it easy to understand and test.

* swagger Url : http://localhost:9090/api/v0/swagger-ui.html#!

**Getting Started**

To run the Garage Car Sales API locally, follow these steps:

*Clone the Git repository.*

Set up your preferred development environment.
Build and run the Spring Boot application.
Access the Swagger documentation to explore and test the API.
Contributing
Contributions to this project are welcome. If you encounter issues, have suggestions, or want to contribute code or documentation, please open an issue or submit a pull request.

**License**

This project is licensed under the MIT License. See the LICENSE file for details.