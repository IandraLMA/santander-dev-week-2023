package me.dio.controller.exception;

import me.dio.component.FormataErrorComponent;
import me.dio.dto.GeralErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private FormataErrorComponent formataErrorComponent;
    private final Logger logger  = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<GeralErrorDTO> handleBusinessException(IllegalArgumentException businessException) {
        return new ResponseEntity<>(formataErrorComponent.formataErroGeral(businessException,HttpStatus.UNPROCESSABLE_ENTITY), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<GeralErrorDTO> handleNotFoundException(NoSuchElementException notFoundException) {
        return new ResponseEntity<>(formataErrorComponent.formataErroGeral(notFoundException,HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<GeralErrorDTO> handleUnexpectedException(Throwable unexpectedException) {
        logger.error(unexpectedException.getMessage(), unexpectedException);
        return new ResponseEntity<>(formataErrorComponent.formataErroGeral(unexpectedException,HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
