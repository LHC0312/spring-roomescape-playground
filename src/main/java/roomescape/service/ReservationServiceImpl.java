package roomescape.service;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomescape.dao.ReservationDao;
import roomescape.domain.Reservation;
import roomescape.handler.exception.ReservationException;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

  private final ReservationDao reservationDao;

  private final List<Reservation> reservations = new ArrayList<>();

  @Override
  public Reservation create(Reservation reservation) {

    return reservationDao.save(reservation);
  }

  @Override
  public Reservation findById(Long id) {

    return reservationDao.findById(id)
        .orElseThrow(() -> new ReservationException("해당되는 예약을 찾을 수 없습니다"));

  }

  @Override
  public Reservation delete(Long id) {

    Reservation reservation = this.findById(id);
    reservationDao.remove(reservation);

    return reservation;
  }

  @Override
  public List<Reservation> findAll() {
    return reservationDao.findAll();
  }
}

