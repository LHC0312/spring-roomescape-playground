package roomescape.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;


public class ReservationReqeustDto {

  @Getter
  public static class CreateReservationDto {

    @NotBlank
    private String name;

    @NotBlank
    private String date;

    @NotBlank
    private String time;
  }
}

