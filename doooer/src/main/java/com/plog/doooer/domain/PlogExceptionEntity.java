package com.plog.doooer.domain;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PlogExceptionEntity {
    private String errCd;
    private String errMsg;

    @Builder
    public PlogExceptionEntity(HttpStatus status, String errCd, String errMsg) {
        this.errCd = errCd;
        this.errMsg = errMsg;
    }
}
