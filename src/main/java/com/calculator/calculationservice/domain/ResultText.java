package com.calculator.calculationservice.domain;

public class ResultText {
	
	private String result;
	
	private String status;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public ResultText() {
	}

	public ResultText(String result, String status) {
		super();
		this.result = result;
		this.status = status;
	}
	
	

}
