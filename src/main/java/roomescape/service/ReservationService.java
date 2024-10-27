package roomescape.service;

import java.util.List;
import roomescape.domain.Reservation;

public interface ReservationService {

  Reservation findById(Integer id);
  List<Reservation> findAll();
  Reservation create(final Reservation reservation);
  Reservation delete(final Integer id);
}
