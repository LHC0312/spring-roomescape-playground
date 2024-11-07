package roomescape.service;

import java.util.List;
import roomescape.domain.Reservation;
import roomescape.dto.ReservationReqeustDto;

public interface ReservationService {

  Reservation findById(Long id);
  List<Reservation> findAll();
  Reservation create(final ReservationReqeustDto.CreateReservationDto request);
  Reservation delete(final Long id);
}
