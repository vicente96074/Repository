package com.kojstarinnovations.repository.infraestructure.output.persistence.exception;

import java.util.logging.Logger;

public class ControllerAdvisor {

    public static void printException(Exception e) {
        logger.severe("Ocurrió una excepción: " + e.getMessage());
        logger.severe("Detalles de la excepción:");
        logger.severe(e.toString());
        for (StackTraceElement element : e.getStackTrace()) {
            logger.severe("\t" + element.toString());
        }
    }

    private static Logger logger;
}
