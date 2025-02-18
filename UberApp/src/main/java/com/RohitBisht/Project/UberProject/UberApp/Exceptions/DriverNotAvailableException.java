package com.RohitBisht.Project.UberProject.UberApp.Exceptions;

public class DriverNotAvailableException extends RuntimeException{
    public DriverNotAvailableException() {
        super();
    }

    public DriverNotAvailableException(String message) {
        super(message);
    }
}
