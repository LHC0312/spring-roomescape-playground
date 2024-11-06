package roomescape.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import roomescape.domain.Reservation;

@Repository
public class ReservationDao {

  private final JdbcTemplate jdbcTemplate;

  private final RowMapper<Reservation> rowMapper = (resultSet, rowNum) -> {
    return  Reservation.builder()
        .id( resultSet.getLong("id"))
        .name( resultSet.getString("name"))
        .date( resultSet.getDate("date").toLocalDate())
        .time( resultSet.getTime("time").toLocalTime())
        .build();
  };
  
  public ReservationDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public Optional<Reservation> findById(Long id) {
    return Optional.ofNullable(jdbcTemplate.queryForObject(
        "id, name, date, time from reservation where id = ?", rowMapper, id
    ));
  }

  public List<Reservation> findAll() {
    return jdbcTemplate.query(
        "select id, name, date, time from reservation",rowMapper
    );
  }

}
