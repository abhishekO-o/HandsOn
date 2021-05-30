package com.cognizant.springlearn.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
@RequestMapping("/countries")
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	private static final ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");
	
	private final CountryService service = new CountryService();
	
	@RequestMapping(value = "/in", method = RequestMethod.GET)
	public Country getCountryIndia() throws IOException {
		LOGGER.debug("Start of get country india");

		Country india = ctx.getBean("in", Country.class);
		LOGGER.debug("End of get country india");
		return india;
	}
	
	@GetMapping
	public List<Country> getAllCountries() {
		List<Country> countries = (List<Country>) ctx.getBean("countryList");
		return countries;
	}
	
	@GetMapping(value = "/{code}")
	public Country getCountry(@PathVariable("code") String code) throws IOException, CountryNotFoundException {
		return service.getCountry(code);
	}
	
	@PostMapping
	public Country addCountry(@RequestBody @Valid Country country)  {
		LOGGER.debug("Start");
		return country;
	}
}
