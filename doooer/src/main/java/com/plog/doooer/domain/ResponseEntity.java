package com.plog.doooer.domain;

import lombok.Data;

@Data
public class ResponseEntity {
	private String status;
	private String msg;
	private String errMsg;
	private String errCode;
	
	public ResponseEntity() {}
	
//	public ResponseEntity(Map data) {
//		this.status = data.
//		
//	}
}
