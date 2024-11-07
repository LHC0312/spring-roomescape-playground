package roomescape.service;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomescape.converter.ReservationConverter;
import roomescape.converter.TimeConverter;
import roomescape.dao.ReservationDao;
import roomescape.dao.TimeDao;
import roomescape.domain.Reservation;
import roomescape.domain.Time;
import roomescape.dto.ReservationReqeustDto;
import roomescape.handler.exception.ReservationException;
import roomescape.handler.exception.TimeException;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

  private final ReservationDao reservationDao;
  private final TimeService timeService;

  private final List<Reservation> reservations = new ArrayList<>();

  @Override
  public Reservation create(ReservationReqeustDto.CreateReservationDto request) {
    Time time = timeService.findById(request.getTime());
    Reservation reservation = ReservationConverter.toReservation(request, time);
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

