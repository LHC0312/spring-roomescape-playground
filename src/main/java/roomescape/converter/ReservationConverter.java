package roomescape.converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import roomescape.domain.Reservation;
import roomescape.domain.Time;
import roomescape.dto.ReservationReqeustDto;
import roomescape.dto.ReservationResponseDto;

public class ReservationConverter {


  public static ReservationResponseDto.ResponseDto toResponseDto(Reservation reservation) {


    return ReservationResponseDto.ResponseDto.builder()
        .id(reservation.getId())
        .name(reservation.getName())
        .date(reservation.getDate())
        .time(reservation.getTime().getTime())
        .build();
  }

  public static List<ReservationResponseDto.ResponseDto> toResponseDto(List<Reservation> reservations) {
    return reservations.stream()
        .map(ReservationConverter::toResponseDto).collect(
        Collectors.toList());
  }

  public static Reservation toReservation(ReservationReqeustDto.CreateReservationDto request, Time time) {


    return Reservation.builder()
        .name(request.getName())
        .date(request.getDate())
        .time(time)
        .build();
  }

}
