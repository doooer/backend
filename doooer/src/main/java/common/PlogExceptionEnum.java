package common;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum PlogExceptionEnum {
    RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "E0001"),
    ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, "E0002"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E0003"),
    SECURITY_01(HttpStatus.UNAUTHORIZED, "S0001", "권한이 없습니다."),
	SECURITY_02(HttpStatus.BAD_REQUEST, "S0002", "ID 또는 PASSWORD가 틀립니다.");

    private final HttpStatus status;
    private final String code;
    private String message;

    PlogExceptionEnum(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
    }

    PlogExceptionEnum(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}