package com.mynotes.app.utils;

import org.springframework.stereotype.Component;

@Component
public class JSONAnswer {
	
	private String message;
	private String code;
	private boolean result;
	private Object data;
	
	
	
	public JSONAnswer() {
		super();
	}
	public JSONAnswer(String message, String code, boolean result, Object data) {
		super();
		this.message = message;
		this.code = code;
		this.result = result;
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
	
	
	

}
