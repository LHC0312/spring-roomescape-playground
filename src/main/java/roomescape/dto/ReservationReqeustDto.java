package roomescape.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;


public class ReservationReqeustDto {

  @Getter
  public static class CreateReservationDto {

    @NotBlank
    private String name;

    @NotBlank
    private String date;

    @NotNull
    private Long time;
  }
}

