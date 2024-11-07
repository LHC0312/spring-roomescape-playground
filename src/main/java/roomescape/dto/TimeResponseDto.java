package roomescape.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TimeResponseDto {

  @Getter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class ResponseDto {
    private Long id;
    private String time;
  }
}
