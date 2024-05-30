package com.kojstarinnovations.repository.application.exceptions;

/**
 * Exception for duplicated objects
 *
 * @author Augusto Vicente
 */
public class DuplicatedException extends RuntimeException{
    public DuplicatedException(String message) {
        super(message);
    }
}
