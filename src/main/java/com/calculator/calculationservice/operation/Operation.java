package com.calculator.calculationservice.operation;

import com.calculator.calculationservice.domain.CalculationNumberResult;

public interface Operation {
	
	public CalculationNumberResult calculate(Integer firstNumber, Integer secondNumber);
	
//	protected boolean isFirstNumOrSecondNumNull(Integer firstNumber, Integer secondNumber) {
//		
//		if(firstNumber != null && secondNumber != null ) {
//			return false;
//		}
//		
//		return true;
//	}

}
