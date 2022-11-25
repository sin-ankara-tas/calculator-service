package com.calculator.calculationservice.operation;

import com.calculator.calculationservice.domain.CalculationNumberResult;

public class Subtraction implements Operation{

	@Override
	public CalculationNumberResult calculate(Integer firstNumber, Integer secondNumber) {
		
		Integer result = firstNumber - secondNumber;
		return new CalculationNumberResult("OK", result);

	}

}
