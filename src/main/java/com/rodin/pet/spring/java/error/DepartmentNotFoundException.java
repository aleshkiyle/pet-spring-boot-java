package com.rodin.pet.spring.java.error;

public class DepartmentNotFoundException extends Exception{

    public DepartmentNotFoundException() {
    }

    public DepartmentNotFoundException(String message) {
        super(message);
    }

    public DepartmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotFoundException(Throwable cause) {
        super(cause);
    }

    public DepartmentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
