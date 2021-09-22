package com.plog.doooer.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDTO {
	private String resCd;
	private String resMsg;
	private Object data;
	
	public ResponseDTO(String resCd, String resMsg) {
		this.resCd = resCd;
		this.resMsg = resMsg;
	}
	public ResponseDTO(String resCd, String resMsg, Object data) {
		this.resCd = resCd;
		this.resMsg = resMsg;
		this.data = data;
	}
}
