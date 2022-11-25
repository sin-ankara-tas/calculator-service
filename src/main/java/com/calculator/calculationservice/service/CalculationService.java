package com.calculator.calculationservice.service;

import com.calculator.calculationservice.domain.CalculationNumber;
import com.calculator.calculationservice.domain.CalculationNumberResult;

public interface CalculationService {
	
	public CalculationNumberResult calculate (CalculationNumber calculation);

}
