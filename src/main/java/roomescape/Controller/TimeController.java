package roomescape.controller;

import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import roomescape.converter.TimeConverter;
import roomescape.domain.Time;
import roomescape.dto.TimeRequestDto;
import roomescape.dto.TimeResponseDto;
import roomescape.dto.TimeResponseDto.ResponseDto;
import roomescape.service.TimeService;

@RequiredArgsConstructor
@Controller
public class TimeController {

  private final TimeService timeService;

  @GetMapping("/times")
  public ResponseEntity<List<ResponseDto>> getTimes() {
    List<Time> times = timeService.findAll();
    return ResponseEntity.ok().body(TimeConverter.toResponseDto(times));
  }

  @PostMapping("/times")
  public ResponseEntity<TimeResponseDto.ResponseDto> creatTime(@RequestBody TimeRequestDto.createDto request) {

    Time time = TimeConverter.toTime(request);
    timeService.create(time);

    String uri = "/times/" + time.getId();
    return ResponseEntity.created(URI.create(uri)).body(TimeConverter.toResponseDto(time));
  }

  @DeleteMapping("/times/{id}")
  public ResponseEntity<TimeResponseDto.ResponseDto> deleteTime(@PathVariable Long id) {
    timeService.delete(id);
    return ResponseEntity.noContent().build();
  }
}