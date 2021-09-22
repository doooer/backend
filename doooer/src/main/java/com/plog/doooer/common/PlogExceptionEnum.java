package com.plog.doooer.common;

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
	LOGIN_01(HttpStatus.BAD_REQUEST, "L0001", "ID 또는 PASSWORD가 틀립니다."),
	UPDATE_01(HttpStatus.BAD_REQUEST, "U0001", "업데이트에 실패했습니다.");

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