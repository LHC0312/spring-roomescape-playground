package roomescape.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomescape.dao.ReservationDao;
import roomescape.domain.Reservation;
import roomescape.handler.exception.UserException;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

  private final ReservationDao reservationDao;

  static AtomicLong index = new AtomicLong(0);
  private final List<Reservation> reservations = new ArrayList<>();

  @Override
  public Reservation create(Reservation reservation) {

    reservation.generateId(index.incrementAndGet());
    reservations.add(reservation);

    return reservation;
  }

  @Override
  public Reservation findById(Long id) {

    return reservationDao.findById(id)
        .orElseThrow(() -> new UserException("해당되는 예약을 찾을 수 없습니다"));

  }

  @Override
  public Reservation delete(Long id) {

    Reservation reservation = this.findById(id);
    reservations.remove(reservation);

    return reservation;
  }

  @Override
  public List<Reservation> findAll() {
    return reservationDao.findAll();
  }
}

