
package com.rts.bo;

public class Response {
	private String status;
	private Long listCount;
	private String message;
	private String errorText;
	private Object result;


	public Long getListCount() {
		return listCount;
	}

	public void setListCount(Long listCount) {
		this.listCount = listCount;
	}


	public void setStatus(String string) {
		this.status = string;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getErrorText() {
		return errorText;
	}

	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

	public String getStatus() {
		return status;
	}



}
