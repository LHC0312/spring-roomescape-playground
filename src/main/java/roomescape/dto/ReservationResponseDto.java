package roomescape.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class ReservationResponseDto {

  @Getter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class ResponseDto {

    private Integer id;
    private String name;
    private String date;
    private String time;
  }
}

