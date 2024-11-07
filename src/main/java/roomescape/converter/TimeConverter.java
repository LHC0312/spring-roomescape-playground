package roomescape.converter;


import java.util.List;
import java.util.stream.Collectors;
import roomescape.domain.Time;
import roomescape.dto.TimeRequestDto;
import roomescape.dto.TimeResponseDto;

public class TimeConverter {

  public static TimeResponseDto.ResponseDto toResponseDto(Time time) {

    return TimeResponseDto.ResponseDto.builder()
        .id(time.getId())
        .time(time.getTime())
        .build();
  }

  public static List<TimeResponseDto.ResponseDto> toResponseDto(List<Time> times) {
    return times.stream()
        .map(TimeConverter::toResponseDto).collect(
        Collectors.toList());
  }

  public static Time toTime(TimeRequestDto.createDto request) {

    return Time.builder()
        .time(request.getTime())
        .build();
  }

}
