package roomescape.dto;

import lombok.Getter;


public class ReservationReqeustDto {

  @Getter
  public static class CreateReservationDto {
    private String name;
    private String date;
    private String time;
  }
}

