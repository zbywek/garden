package pl.infomind.garden.exception;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Builder
@Data
public class ErrorResponse {

    private String message;
    private ZonedDateTime timestamp;
}
