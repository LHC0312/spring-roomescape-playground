package roomescape.domain;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class Time {
  private Long id;
  private String time;

  public void generateId(Long id) {
    this.id = id;
  }
}