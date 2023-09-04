package com.garage.carsales.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Value(value = "$data.exception.notExist")
    private String notFound;

    @Value(value = "Only car registered after 2015 are allowed to be add to the catalog")
    private String registrationDate;


    @ExceptionHandler(value = RegistrationDateException.class)
    public ResponseEntity<String> registrationDateException() {
        return new ResponseEntity<>(registrationDate, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = CarNotFoundException.class)
    public ResponseEntity<String> carNotFoundException(CarNotFoundException carNotFoundException) {
        return new ResponseEntity<>(carNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<String> enumParseError(HttpMessageNotReadableException exception) {
        return new ResponseEntity<>("Change the enum value:  " + exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

