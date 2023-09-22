package org.adaschool.Weather;

import org.adaschool.Weather.controller.WeatherReportController;
import org.adaschool.Weather.data.WeatherReport;
import org.adaschool.Weather.service.WeatherReportService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class WeatherApplicationTests {

	@Mock
	private WeatherReportController weatherReportController;

	@InjectMocks
	private WeatherReportService weatherReportService;

	@Mock
	private WeatherReport weatherReport;

	@Test
	void contextLoads() {
		MockitoAnnotations.initMocks(this);
		when(weatherReportController.getWeatherReport(37.8267, -122.4233)).thenReturn(weatherReport);
		WeatherReport trialWeather = weatherReportService.getWeatherReport(37.8267, -122.4233);
		Assert.assertEquals(trialWeather.getTemperature(), weatherReport.getTemperature(), 1);
	}

}