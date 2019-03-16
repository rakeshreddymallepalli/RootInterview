package com.root.inter;

public class BooleanResult {
	

	public BooleanResult()
	{
	}
	
	public BooleanResult(boolean result, String message)
	{
        this.result = result;
		this.message = message;
	}
	
	private boolean result = false;
	private String message = "";
	
	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
