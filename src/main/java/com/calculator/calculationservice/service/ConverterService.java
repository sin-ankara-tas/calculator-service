package com.calculator.calculationservice.service;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.calculator.calculationservice.config.CalculatorProperties;
import com.calculator.calculationservice.domain.CalculationNumber;
import com.calculator.calculationservice.domain.CalculationText;
import com.calculator.calculationservice.domain.CalculationType;
import com.calculator.calculationservice.domain.ResultText;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ConverterService {

	private final RestTemplate restTemplate;

	private final CalculatorProperties calculatorProperties;

	private final ObjectMapper objectMapper = new ObjectMapper();
	
    private static final Logger logger = LoggerFactory.getLogger(ConverterService.class);

	public ConverterService(CalculatorProperties calculatorProperties) {

		this.restTemplate = new RestTemplate();

		this.restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		this.restTemplate.getMessageConverters().add(new StringHttpMessageConverter(StandardCharsets.UTF_8));

		this.calculatorProperties = calculatorProperties;
	}

	private ResponseEntity<String> createPostRequestWithCalculationText(CalculationText calculationText, Locale locale) {
		String url = this.calculatorProperties.getConverterServiceUrl() + "/texttonumber";
		
		JSONObject requestBody = convertCalculationTextToJSON(calculationText);

		HttpHeaders headers = createRequestHeader(locale);
 
		HttpEntity<String> entity = new HttpEntity<String>(requestBody.toString(), headers);

		// send POST request
		return restTemplate.postForEntity(url, entity, String.class);
	}
	
	private ResponseEntity<String> createPostRequestWithCalculationNumber(CalculationNumber calculationNummber, Locale locale) {
		String url = this.calculatorProperties.getConverterServiceUrl() + "/numbertotext";
		
		JSONObject requestBody = convertCalculationNumberToJSON(calculationNummber);

		HttpHeaders headers = createRequestHeader(locale);
 
		HttpEntity<String> entity = new HttpEntity<String>(requestBody.toString(), headers);

		// send POST request
		return restTemplate.postForEntity(url, entity, String.class);
	}
	
	private HttpHeaders createRequestHeader(Locale locale) {
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = new MediaType("application", "json", StandardCharsets.UTF_8);
		headers.setContentType(mediaType);
		headers.setContentLanguage(locale);
		
		return headers;
	}

	private JSONObject convertCalculationTextToJSON(CalculationText calculationText) {
		
		JSONObject calculationJSON = new JSONObject();
	
		calculationJSON.put("firstNumberText", calculationText.getFirstNumberText());
		calculationJSON.put("secondNumberText", calculationText.getSecondNumberText());
		calculationJSON.put("calculationType", calculationText.getCalculationType());
		
		return calculationJSON;
	}
	
	private JSONObject convertCalculationNumberToJSON(CalculationNumber calculationNumber) {
	
		JSONObject calculationJSON = new JSONObject();
	
		calculationJSON.put("firstNumber", calculationNumber.getFirstNumber());
		calculationJSON.put("secondNumber", calculationNumber.getSecondNumber());
		calculationJSON.put("calculationType", calculationNumber.getCalculationType());
		
		return calculationJSON;
	}

	private CalculationNumber toCalculationResultNumber(String body) {
		try {
			return this.objectMapper.readValue(body, CalculationNumber.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			logger.error("Error in reading value with object mapper. Error Message: " + e.getMessage());
			return new CalculationNumber(0, 0, CalculationType.ADDITION);
		}
	}
	
	private ResultText toCalculationResultText(String body) {
		try {
			CalculationText calculationText = this.objectMapper.readValue(body, CalculationText.class);
			return new ResultText(calculationText.getFirstNumberText(), "OK");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			logger.error("Error in reading value with object mapper. Error Message: " + e.getMessage());
			return new ResultText("sıfır", "NOK");
		}
	}

	//TODO??
	public CalculationNumber getConvertedCalculation(CalculationText calculationText, Locale locale) {
		
		try {
			ResponseEntity<String> response = createPostRequestWithCalculationText(calculationText, locale);

			if (response.getStatusCodeValue() == 200) {
				return toCalculationResultNumber(response.getBody());
			}
			
			return new CalculationNumber(0, 0, CalculationType.ADDITION);		
	
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("Error in converting calculation number. Error Message: " + e.getMessage());
			return new CalculationNumber(0, 0, CalculationType.ADDITION);
		}
	}

	public ResultText getCalculationResultText(CalculationNumber calculationNumber, Locale locale) {

		try {
			ResponseEntity<String> response = createPostRequestWithCalculationNumber(calculationNumber, locale);

			if (response.getStatusCodeValue() == 200) {
				return toCalculationResultText(response.getBody());
			}
			
			return new ResultText("-", "NOK");	
	
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("Error in converting calculation number. Error Message: " + e.getMessage());
			return new ResultText("-", "NOK");	
		}
		
	}
}
