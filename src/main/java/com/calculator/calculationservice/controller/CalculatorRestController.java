package com.calculator.calculationservice.controller;

import java.util.Locale;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.calculationservice.domain.CalculationText;
import com.calculator.calculationservice.domain.ResultText;
import com.calculator.calculationservice.service.ConvertAndCalculateService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/calculator")
public class CalculatorRestController {

  
	private final ConvertAndCalculateService convertAndCalculateService;

    public CalculatorRestController(ConvertAndCalculateService convertAndCalculateService) {
        this.convertAndCalculateService = convertAndCalculateService;
    }

    @PostMapping( path = "/calculate",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultText calculate( @RequestBody CalculationText calculationText, 
    		@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return this.convertAndCalculateService.convertAndCalculate(calculationText, locale);
    }
}


//TODO: Swagger