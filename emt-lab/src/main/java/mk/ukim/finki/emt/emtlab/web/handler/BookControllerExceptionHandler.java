package mk.ukim.finki.emt.emtlab.web.handler;

import mk.ukim.finki.emt.emtlab.model.exception.AuthorNotFoundException;
import mk.ukim.finki.emt.emtlab.web.controller.BookController;
import mk.ukim.finki.emt.emtlab.web.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = BookController.class)
public class BookControllerExceptionHandler {
    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(AuthorNotFoundException exception) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ApiError.of(HttpStatus.NOT_FOUND, exception.getMessage()));
    }
}
