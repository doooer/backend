package common;

import lombok.Getter;

@Getter
public class PlogException extends RuntimeException{
	
	private PlogExceptionEnum error;

    public PlogException(PlogExceptionEnum e) {
        super(e.getMessage());
        this.error = e;
    }
    
}
