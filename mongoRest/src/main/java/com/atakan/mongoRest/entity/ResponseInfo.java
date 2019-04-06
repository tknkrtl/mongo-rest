package com.atakan.mongoRest.entity;

public class ResponseInfo {

	private String info;
	private int status;
	
	public ResponseInfo() {
	
	}

	public ResponseInfo(String info, int status) {
		this.info = info;
		this.status = status;
	}
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
	
	
}
