package roomescape.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import roomescape.handler.exception.UserException;;

@ControllerAdvice
public class ErrorHandler {

  @ExceptionHandler(UserException.class)
  public ResponseEntity handleException(UserException e) {
    return ResponseEntity.badRequest().build();
  }
}
