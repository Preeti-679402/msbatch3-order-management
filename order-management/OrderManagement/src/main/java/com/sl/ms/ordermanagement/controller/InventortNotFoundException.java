package com.sl.ms.ordermanagement.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InventortNotFoundException extends RuntimeException {

    private static Logger LOGGER = LogManager.getLogger(InventortNotFoundException.class);

    public InventortNotFoundException(String exception) {
        super(exception);
        LOGGER.info("InventortNotFoundException class with exception"+exception);
    }

}
