package Assignment.Bookstore.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
    @ControllerAdvice
    public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorDetails> handleException(Exception ex) {
            return new ResponseEntity<>(new ErrorDetails(new Date(), 500, "Internal Server Error: " + ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


