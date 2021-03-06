package com.socialsend.sendapi.response;


public class Response<T> {

	
	private String status;
	private String message;
	private T data;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	
	public Response(T data){
		
		this.data = data;
		this.status = "OK";
		this.message = "";
		
		
	}
	
	
}
