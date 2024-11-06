package roomescape.converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import roomescape.domain.Reservation;
import roomescape.dto.ReservationReqeustDto;
import roomescape.dto.ReservationResponseDto;

public class ReservationConverter {


  public static ReservationResponseDto.ResponseDto toResponseDto(Reservation reservation) {

    LocalDate date = reservation.getDate();
    LocalTime time = reservation.getTime();

    return ReservationResponseDto.ResponseDto.builder()
        .id(reservation.getId())
        .name(reservation.getName())
        .date(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
        .time(time.format(DateTimeFormatter.ofPattern("HH:mm")))
        .build();
  }

  public static List<ReservationResponseDto.ResponseDto> toResponseDto(List<Reservation> reservations) {
    return reservations.stream()
        .map(ReservationConverter::toResponseDto).collect(
        Collectors.toList());
  }

  public static Reservation toReservation(ReservationReqeustDto.CreateReservationDto request) {

    String dateString = request.getDate();
    LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    String timeString = request.getTime();
    LocalTime time = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm"));

    return Reservation.builder()
        .name(request.getName())
        .date(date)
        .time(time)
        .build();
  }

}
