package com.calculator.calculationservice.domain;

public class CalculationNumberResult {

	private String resultStatus;
	
    private Integer resultValue;
    
	public CalculationNumberResult(String resultStatus, Integer resultValue) {
		super();
		this.resultStatus = resultStatus;
		this.resultValue = resultValue;
	}

	public String getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

	public Integer getResultValue() {
		return resultValue;
	}

	public void setResultValue(Integer resultValue) {
		this.resultValue = resultValue;
	}
}
