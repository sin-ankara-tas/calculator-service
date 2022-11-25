package com.calculator.calculationservice.service;

import java.util.Locale;

import org.springframework.stereotype.Service;

import com.calculator.calculationservice.domain.CalculationNumber;
import com.calculator.calculationservice.domain.CalculationNumberResult;
import com.calculator.calculationservice.domain.CalculationText;
import com.calculator.calculationservice.domain.ResultText;

@Service
public class ConvertAndCalculateService {
	
	private final CalculationService calculatorService;
	
	private final ConverterService converterService;
	
	private CalculationNumber calculationNumber;
	
	private CalculationNumberResult calculationNumberResult;
	
	public ConvertAndCalculateService(CalculationService calculatorService, ConverterService converterService) {
		
		this.calculatorService = calculatorService; 
		
		this.converterService = converterService;
	}
	
	public ResultText convertAndCalculate(CalculationText calculationText, Locale locale) {
		
		calculationNumber = converterService.getConvertedCalculation(calculationText, locale);
		
		calculationNumberResult = calculatorService.calculate(calculationNumber);
		
		if(calculationNumberResult.getResultStatus().equals("OK")) {
			
			CalculationNumber result = new CalculationNumber(calculationNumberResult.getResultValue(), calculationNumberResult.getResultValue(), calculationText.getCalculationType());
			return converterService.getCalculationResultText(result, locale) ;
		}
		
		return new ResultText("-", "NOK" );
	}
}
