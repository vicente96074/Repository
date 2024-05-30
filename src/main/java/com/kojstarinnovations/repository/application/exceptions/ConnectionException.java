package com.kojstarinnovations.repository.application.exceptions;

/**
 * Exception to handle connection errors
 *
 * @author Augusto Vicente
 */
public class ConnectionException extends RuntimeException{
    public ConnectionException(String message) {
        super(message);
    }
}
