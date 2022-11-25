package com.calculator.calculationservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.calculator.calculationservice.domain.CalculationNumber;
import com.calculator.calculationservice.domain.CalculationNumberResult;
import com.calculator.calculationservice.domain.CalculationType;
import com.calculator.calculationservice.operation.Addition;
import com.calculator.calculationservice.operation.Division;
import com.calculator.calculationservice.operation.Operation;
import com.calculator.calculationservice.operation.Multiplication;
import com.calculator.calculationservice.operation.Subtraction;

@Service
public class CalculationServiceImpl implements CalculationService {

	private Map<CalculationType, Operation> calculateCommand = new HashMap<CalculationType, Operation>();
	
	public CalculationServiceImpl() {
		calculateCommand.put(CalculationType.ADDITION, new Addition());
		calculateCommand.put(CalculationType.DIVISION, new Division());
		calculateCommand.put(CalculationType.MULTIPLICATION, new Multiplication());
		calculateCommand.put(CalculationType.SUBTRACTION, new Subtraction());
	}
	
	@Override
	public CalculationNumberResult calculate(CalculationNumber calculation) {
		
//		if(!isValidCalculation(calculation)) {
//			return new CalculationResult("NOK", 0); 
//		}
		
		return calculateCommand.get(calculation.getCalculationType()).calculate(calculation.getFirstNumber(), calculation.getSecondNumber()); 
		
	}
}
