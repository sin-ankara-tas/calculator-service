package com.calculator.calculationservice.domain;

import java.io.Serializable;

public class CalculationText implements Serializable {
	
	private String firstNumberText;
	
	private String secondNumberText;
	
	private CalculationType calculationType;
	
	public CalculationText() {
	}

	public CalculationText(String firstNumberText, String secondNumberText, CalculationType calculationType) {
		super();
		this.firstNumberText = firstNumberText;
		this.secondNumberText = secondNumberText;
		this.calculationType = calculationType;
	}

	public String getFirstNumberText() {
		return firstNumberText;
	}

	public void setFirstNumberText(String firstNumberText) {
		this.firstNumberText = firstNumberText;
	}

	public String getSecondNumberText() {
		return secondNumberText;
	}

	public void setSecondNumberText(String secondNumberText) {
		this.secondNumberText = secondNumberText;
	}

	public CalculationType getCalculationType() {
		return calculationType;
	}

	public void setCalculateType(CalculationType calculationType) {
		this.calculationType = calculationType;
	}
	

}