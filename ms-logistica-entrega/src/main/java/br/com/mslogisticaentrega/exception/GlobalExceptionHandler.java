// br/com/mslogisticaentrega/exception/GlobalExceptionHandler.java
package br.com.mslogisticaentrega.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicidadeException.class)
    public ResponseEntity<String> handleDuplicidadeException(DuplicidadeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
