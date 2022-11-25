package com.calculator.calculationservice.domain;

public class CalculationNumber {
	
    private Integer firstNumber;
	
    private Integer secondNumber;
    
    private CalculationType calculationType;
    
    public CalculationNumber() {
	}
    
    public CalculationNumber(Integer firstNumber, Integer secondNumber, CalculationType calculationType) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.calculationType = calculationType;
	}
    
    public Integer getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(Integer firstNumber) {
		this.firstNumber = firstNumber;
	}

	public Integer getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(Integer secondNumber) {
		this.secondNumber = secondNumber;
	}

	public CalculationType getCalculationType() {
		return calculationType;
	}

	public void setCalculationType(CalculationType calculationType) {
		this.calculationType = calculationType;
	}
//
//	public boolean isValidCalculation() {
//		
//		if (this.calculationType == null || this.firstNumber == null
//				|| this.secondNumber == null) {
//			return false;
//		}
//
//		return true;
//	}
}