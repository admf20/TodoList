package TodoDo_SpringBoot.TodoDo_SpringBoot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 🟥 Validaciones @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class) //cuando hay un error con @Valid Spring lanza automáticamente una excepción llamada MethodArgumentNotValidException, asi que ponemos el metodo que queremo capturar
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>(); //creamos un HashMap, para captuara el key, value que seria el tipo de error y el mensaje

        ex.getBindingResult().getFieldErrors() //el primer metodo se obtien el resultado de la regla que no paso y el segundo el mensaje relacionado con la regla
                .forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());  //utilizamos un for para recorrer los errores y guardarlos en el mapa
                    //el primero metodo es el campo del error y segundo el mensaje que se definio en la entidad con la anotacion
                    //EJEMPLO: @NotBlank(message = "Este campo es obligatorio"))
                });

        return ResponseEntity.badRequest().body(errors);//retornamos una respuesta 404 con su mapa de errores
    }

    // 🔴 Producto duplicado u otra lógica de negocio
    //@ExceptionHandler(IllegalArgumentException.class)
    //@ResponseStatus(HttpStatus.BAD_REQUEST)
    //public Map<String, String> handleIllegalArgument(IllegalArgumentException ex) {
     //   return Map.of("error", ex.getMessage());
    //}

    // ⚠️ Excepciones no controladas
    @ExceptionHandler(Exception.class)
    public Map<String, String> handleAllUncaught(Exception ex) {
        return Map.of("error", "Error interno en el servidor");
    }
}
