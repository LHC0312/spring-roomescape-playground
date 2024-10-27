package roomescape.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;
import roomescape.Enum.ErrorStatus;
import roomescape.domain.Reservation;

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
        .orElseThrow(() -> new RuntimeException(ErrorStatus._NOT_FOUND_RESERVATION.name()));
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

