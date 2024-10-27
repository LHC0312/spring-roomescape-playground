package roomescape.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import roomescape.domain.Reservation;
import roomescape.dto.ReservationReqeustDto;
import roomescape.dto.ReservationResponseDto;

public class ReservationConverter {


  public static ReservationResponseDto.ResponseDto toResponseDto(Reservation reservation) {

    LocalDateTime dateTime = reservation.getDateTime();

    return ReservationResponseDto.ResponseDto.builder()
        .id(reservation.getId())
        .name(reservation.getName())
        .date(dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
        .time(dateTime.format(DateTimeFormatter.ofPattern("HH:mm")))
        .build();
  }

  public static List<ReservationResponseDto.ResponseDto> toResponseDto(List<Reservation> reservations) {
    return reservations.stream()
        .map(ReservationConverter::toResponseDto).collect(
        Collectors.toList());
  }

  public static Reservation toReservation(ReservationReqeustDto.CreateReservationDto request) {

    String string = request.getDate() + " " + request.getTime();
    LocalDateTime dateTime = LocalDateTime.parse(string, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

    return Reservation.builder()
        .name(request.getName())
        .dateTime(dateTime)
        .build();
  }

}
