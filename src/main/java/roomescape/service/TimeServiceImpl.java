package roomescape.service;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomescape.dao.TimeDao;
import roomescape.domain.Reservation;
import roomescape.domain.Time;
import roomescape.handler.exception.ReservationException;
import roomescape.handler.exception.TimeException;

@Service
@RequiredArgsConstructor
public class TimeServiceImpl implements TimeService {

  private final TimeDao timeDao;

  private final List<Time> time = new ArrayList<>();

  @Override
  public Time create(Time time) {

    return timeDao.save(time);
  }

  @Override
  public Time findById(Long id) {

    return timeDao.findById(id)
        .orElseThrow(() -> new TimeException("해당되는 시간을 찾을 수 없습니다"));

  }

  @Override
  public Time delete(Long id) {

    Time time = this.findById(id);
    timeDao.remove(time);

    return time;
  }

  @Override
  public List<Time> findAll() {
    return timeDao.findAll();
  }
}

