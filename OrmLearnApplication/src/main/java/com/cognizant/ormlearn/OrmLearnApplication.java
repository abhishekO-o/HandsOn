package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	// Include a static reference to CountryService in OrmLearnApplication class
	private static CountryService countryService;

	public static void main(String[] args) throws CountryNotFoundException {
		// SpringApplication.run(OrmLearnApplication.class, args);
		// Create applicationContext
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		// Include logs for verifying if main() is called..
		LOGGER.info("Inside main!!");
		// Get the CountryService Bean
		countryService = context.getBean(CountryService.class);
		// Call The testGetAllCountries()
		testGetAllCountries();
		// Call getAllCountriesTest
		getAllCountriesTest();
		// Call Add country
		testAddCountry();
		// Call the testUpdateCountry
		testUpdateCountry();
		//test the testDeleteCountry
		testDeleteCountry();
	}

	// Test Method for getting all countries
	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	// Test method for findCountryByCode
	private static void getAllCountriesTest() throws CountryNotFoundException {
		Country country = countryService.findCountryByCode("YE");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");
	}

	// Test the addCountry method
	private static void testAddCountry() throws CountryNotFoundException {
		Country country = new Country();
		country.setCo_code("XY");
		country.setCo_name("SPAIN");
		countryService.addCountry(country);
		countryService.findCountryByCode("XY");
	}
	//Test the update country method
	private static void testUpdateCountry() {
		countryService.updateCountry("AUSTRALLIA", "XY");
	}
	//Test the deleteCountry method
	private static void testDeleteCountry(){
		countryService.deleteCountry("XY");
	}
}
