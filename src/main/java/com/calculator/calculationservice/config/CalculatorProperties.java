package com.calculator.calculationservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "calculator")
public class CalculatorProperties {
    private static final String CONVERTER_SERVICE_DEFAULT_URL = "http://localhost:8082/converter";

    private String converterServiceUrl = CONVERTER_SERVICE_DEFAULT_URL;

    public CalculatorProperties() {
    }

	public String getConverterServiceUrl() {
		return converterServiceUrl;
	}
}
