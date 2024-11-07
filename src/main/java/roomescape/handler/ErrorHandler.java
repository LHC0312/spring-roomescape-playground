package roomescape.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import roomescape.handler.exception.ReservationException;
import roomescape.handler.exception.TimeException;;

@ControllerAdvice
public class
ErrorHandler {

  @ExceptionHandler(ReservationException.class)
  public ResponseEntity handleException(ReservationException e) {
    return ResponseEntity.badRequest().build();
  }

  @ExceptionHandler(TimeException.class)
  public ResponseEntity handleException(TimeException e) {
    return ResponseEntity.badRequest().build();
  }
}
