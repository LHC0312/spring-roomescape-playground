package roomescape.controller;

import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import roomescape.converter.ReservationConverter;
import roomescape.domain.Reservation;
import roomescape.dto.ReservationReqeustDto;
import roomescape.dto.ReservationResponseDto;
import roomescape.dto.ReservationResponseDto.ResponseDto;
import roomescape.service.ReservationService;

@RequiredArgsConstructor
@Controller
public class ReservationController {

  private final ReservationService reservationService;

  @GetMapping("/reservation")
  public String reservation() {
    return "home";
  }

  @GetMapping("/reservations")
  public ResponseEntity<?> reservations() {
    List<Reservation> reservations = reservationService.findAll();
    return ResponseEntity.ok().body(ReservationConverter.toResponseDto(reservations));
  }

  @PostMapping("/reservations")
  public ResponseEntity<?> createReservation (@RequestBody ReservationReqeustDto.CreateReservationDto request) {

    Reservation reservation = ReservationConverter.toReservation(request);
    reservationService.create(reservation);

    String url = "/reservations/" + reservation.getId();

    return ResponseEntity.created(URI.create(url)).body(ReservationConverter.toResponseDto(reservation));
  }

  @DeleteMapping("/reservations/{id}")
  public ResponseEntity<Void> createReservation (@PathVariable Integer id) {

    Reservation reservation = reservationService.delete(id);
    return ResponseEntity.noContent().build();
  }


}