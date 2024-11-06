package roomescape.dao;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import roomescape.domain.Reservation;

@Repository
public class ReservationDao {

  private final JdbcTemplate jdbcTemplate;

  private final RowMapper<Reservation> rowMapper = (resultSet, rowNum) -> {


    return Reservation.builder()
        .id(resultSet.getLong("id"))
        .name(resultSet.getString("name"))
        .date(resultSet.getDate("date").toLocalDate())
        .time(resultSet.getTime("time").toLocalTime())
        .build();
  };

  public ReservationDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public Optional<Reservation> findById(Long id) {
    return jdbcTemplate.query(
        "select id, name, date, time from reservation where id = ?", rowMapper, id
    ).stream().findFirst();
  }

  public List<Reservation> findAll() {
    return jdbcTemplate.query(
        "select id, name, date, time from reservation", rowMapper
    );
  }

  public Reservation save(Reservation reservation) {
    KeyHolder keyHolder = new GeneratedKeyHolder();

    jdbcTemplate.update(connection -> {
          PreparedStatement ps = connection.prepareStatement(
              "INSERT INTO reservation (name, date, time) values (?, ?, ?)",
              new String[]{"id"}
          );
          ps.setString(1, reservation.getName());
          ps.setString(2, reservation.getDate().toString());
          ps.setString(3, reservation.getTime().toString());
          return ps;
        }, keyHolder);
    Long id = keyHolder.getKey().longValue();
    reservation.generateId(id);

    return reservation;
  }

  public void remove(Reservation reservation) {
    jdbcTemplate.update(
        "delete from reservation where id = ?", reservation.getId()
    );
  }

}