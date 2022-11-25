package com.calculator.calculationservice.operation;

import com.calculator.calculationservice.domain.CalculationNumberResult;

public class Division implements Operation {

	@Override
	public CalculationNumberResult calculate(Integer firstNumber, Integer secondNumber) {

		Integer result = 0;
		String resultString = "NOK";

		if (firstNumber != null && secondNumber != null && secondNumber != 0) {
			result = firstNumber / secondNumber;
			resultString = "OK";
		}

		return new CalculationNumberResult(resultString, result);
	}

}
