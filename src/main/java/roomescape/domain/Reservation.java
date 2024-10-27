package roomescape.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class Reservation {

  private Integer id;
  private String name;
  private LocalDateTime dateTime;

  public void generateId(Integer id) {
    this.id = id;
  }
}
