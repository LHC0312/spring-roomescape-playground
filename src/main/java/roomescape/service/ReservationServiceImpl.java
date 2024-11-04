package roomescape.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;
import roomescape.domain.Reservation;
import roomescape.handler.exception.UserException;

@Service
public class ReservationServiceImpl implements ReservationService {

  static AtomicInteger index = new AtomicInteger(0);
  private final List<Reservation> reservations = new ArrayList<>();

  @Override
  public Reservation create(Reservation reservation) {

    reservation.generateId(index.incrementAndGet());
    reservations.add(reservation);

    return reservation;
  }

  @Override
  public Reservation findById(Integer id) {
    return reservations.stream()
        .filter(reservation -> reservation.getId().equals(id)).findFirst()
        .orElseThrow(() -> new UserException("해당되는 예약을 찾을 수 없습니다"));
  }

  @Override
  public Reservation delete(Integer id) {

    Reservation reservation = this.findById(id);
    reservations.remove(reservation);

    return reservation;
  }

  @Override
  public List<Reservation> findAll() {
    return reservations;
  }
}

