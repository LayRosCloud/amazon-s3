package com.betrayal.amazons3test.handler;

import com.betrayal.amazons3test.exception.CloudUnavailableException;
import jakarta.servlet.UnavailableException;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;

@ControllerAdvice
@Slf4j
public class ExceptionProvider {
    @ExceptionHandler({BadRequestException.class, CloudUnavailableException.class, IOException.class})
    public ResponseEntity<Object> handleBadRequestException(Exception ex, WebRequest request){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleException(Exception ex, WebRequest request){
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
