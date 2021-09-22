package com.plog.doooer.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.plog.doooer.domain.PlogExceptionEntity;

@RestControllerAdvice
public class PlogExceptionAdvice {
    @ExceptionHandler(PlogException.class)
    public ResponseEntity<PlogExceptionEntity> exceptionHandler(HttpServletRequest request, final PlogException e) {
        return ResponseEntity
                .status(e.getError().getStatus())
                .body(PlogExceptionEntity.builder()
                        .errCd(e.getError().getCode())
                        .errMsg(e.getError().getMessage())
                        .build());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<PlogExceptionEntity> exceptionHandler(HttpServletRequest request, final RuntimeException e) {
        return ResponseEntity
                .status(PlogExceptionEnum.RUNTIME_EXCEPTION.getStatus())
                .body(PlogExceptionEntity.builder()
                        .errCd(PlogExceptionEnum.RUNTIME_EXCEPTION.getCode())
                        .errMsg(e.getMessage())
                        .build());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<PlogExceptionEntity> exceptionHandler(HttpServletRequest request, final AccessDeniedException e) {
        return ResponseEntity
                .status(PlogExceptionEnum.ACCESS_DENIED_EXCEPTION.getStatus())
                .body(PlogExceptionEntity.builder()
                        .errCd(PlogExceptionEnum.ACCESS_DENIED_EXCEPTION.getCode())
                        .errMsg(e.getMessage())
                        .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<PlogExceptionEntity> exceptionHandler(HttpServletRequest request, final Exception e) {
        return ResponseEntity
                .status(PlogExceptionEnum.INTERNAL_SERVER_ERROR.getStatus())
                .body(PlogExceptionEntity.builder()
                        .errCd(PlogExceptionEnum.INTERNAL_SERVER_ERROR.getCode())
                        .errMsg(e.getMessage())
                        .build());
    }
}