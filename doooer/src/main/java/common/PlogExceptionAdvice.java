package common;

import java.nio.file.AccessDeniedException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.plog.doooer.domain.PlogExceptionEntity;

@ControllerAdvice
public class PlogExceptionAdvice {
    @ExceptionHandler(PlogException.class)
    public ResponseEntity<PlogExceptionEntity> exceptionHandler(HttpServletRequest request, final PlogException e) {
    	System.out.println("우수연 바보");
        return ResponseEntity
                .status(e.getError().getStatus())
                .body(PlogExceptionEntity.builder()
                        .errCd(e.getError().getCode())
                        .errMsg(e.getError().getMessage())
                        .build());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<PlogExceptionEntity> exceptionHandler(HttpServletRequest request, final RuntimeException e) {
        e.printStackTrace();
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
        e.printStackTrace();
        return ResponseEntity
                .status(PlogExceptionEnum.INTERNAL_SERVER_ERROR.getStatus())
                .body(PlogExceptionEntity.builder()
                        .errCd(PlogExceptionEnum.INTERNAL_SERVER_ERROR.getCode())
                        .errMsg(e.getMessage())
                        .build());
    }
}