package roomescape.dto;

import java.sql.Time;
import lombok.Getter;

public class TimeRequestDto {

  @Getter
  public static class createDto {
    private String time;
  }
}
