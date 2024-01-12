package cat.itacademy.barcelonactiva.bustamante.gabriela.s05.t01.n03.S05T01N03BustamanteGabriela.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
    public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
        @ExceptionHandler(FlorNotFoundException.class)
        public ResponseEntity<String> handleFlorNotFoundException(FlorNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

        // Otros manejadores de excepciones si es necesario

        // Manejador de excepciones genérico para cualquier otra excepción no manejada
        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleGenericException(Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }

    }

