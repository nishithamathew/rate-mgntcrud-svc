package com.task.ratemanagementsystem.exceptions;

import com.task.ratemanagementsystem.model.ErrorResponse;
import org.hibernate.service.spi.ServiceException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RMSExceptionHandlerTest {

    @InjectMocks
    RMSExceptionHandler rmsExceptionHandler;

    RateNotFound rateNotFound = new RateNotFound("Rate not found message");

    ServerException serverException = new ServerException("server message");

    @Test
    void testHandleRateNotFound() {
        ResponseEntity<ErrorResponse> mono = rmsExceptionHandler.handleRateNotFound(rateNotFound);
        assertEquals(HttpStatus.NOT_FOUND,mono.getStatusCode());
    }

    @Test
    void testHandleInternalServerError() {
        ResponseEntity<ErrorResponse> mono = rmsExceptionHandler.handleInternalServerError(serverException);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,mono.getStatusCode());
    }
}