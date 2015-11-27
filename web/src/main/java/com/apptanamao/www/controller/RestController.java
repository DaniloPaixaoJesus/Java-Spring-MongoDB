package com.apptanamao.www.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.apptanamao.www.service.interfaces.LocationService;
import com.apptanamao.www.vo.LocationVO;

/**
 * Handles requests for the locations nearly.
 */
@Controller
public class RestController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestController.class);
	private Map<String, LocationVO> adlocations = new HashMap<String, LocationVO>();	
	
	@Autowired
    LocationService locationService;
	
	public RestController() {
		
		//pre-initialize the list of locations
		this.adlocations.put("ad01", new LocationVO("ad01", 1002145.65612, 2235874.56451));
		this.adlocations.put("ad02", new LocationVO("ad02", 344234.2343, 234234234.4234));
		this.adlocations.put("ad03", new LocationVO("ad03", 54535.34534, 7868986.432423));
		this.adlocations.put("ad04", new LocationVO("ad04", 35423234.24234, 234234.23423452));
		this.adlocations.put("ad05", new LocationVO("ad05", 243525234.2342352, 4758746.23567863));
		this.adlocations.put("ad06", new LocationVO("ad06", 23563254.25346234, 2345246743.89868765));
		this.adlocations.put("ad07", new LocationVO("ad07", 2354672.6586743, 2536532.24563576));
		this.adlocations.put("ad08", new LocationVO("ad08", 7898687436.5798654, 2353754.25632442));

	}
	
	@RequestMapping(value = "/mongodb", method = RequestMethod.GET)
	@ResponseBody
	public LocationVO testeMongo() {
		return locationService.testeMongoDb();
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "status";
	}
	
	/**
	 * get all locations within database
	 * @return
	 */
	@RequestMapping(value="/locations", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, LocationVO> getAllLocations() {
		logger.info("Inside getAllIssuers() method...");
		
		//TODO: call service, by interface, that returns all locations of the database.
		//the service will call a DAO (interface) that is a repository
		return adlocations;
	}
	
	/**
	 * get location by description and locations
	 * description is optional
	 * @param description
	 * @return
	 */
	@RequestMapping(value="/location/{description}/{latitude}/{longitude}", method=RequestMethod.GET)
	@ResponseBody
	public LocationVO getLocationByDescription(
			@PathVariable("description") String description, 
			@PathVariable("latitude") double latitude,  
			@PathVariable("longitude") double longitude) {
		
		//TODO: call service, by interface, that returns location of the database.
		//the service will call a DAO (interface) that is a repository
		LocationVO location = new LocationVO(description, latitude, longitude);
		
		if (location != null) {
			logger.info("Inside getLocationByDescription, returned: " + location.toString());
		} else {
			logger.info("Inside getLocationByDescription, ticker: " + description + ", NOT FOUND!");
		}
		return location; 
	}
	
	/**
	 * get location by description
	 * @param description
	 * @return
	 */
	@RequestMapping(value="/location/{description}", method=RequestMethod.GET)
	@ResponseBody
	public LocationVO getLocationByDescription(@PathVariable("description") String description) {
		
		//TODO: call service, by interface, that returns location of the database.
		//the service will call a DAO (interface) that is a repository
		LocationVO location = adlocations.get(description); 
		
		if (location != null) {
			logger.info("Inside getLocationByDescription, returned: " + location.toString());
		} else {
			logger.info("Inside getLocationByDescription, ticker: " + description + ", NOT FOUND!");
		}
		return location; 
	}

	@RequestMapping(value="/location/delete/{description}", method=RequestMethod.GET)
	@ResponseBody
	public LocationVO deleteLocationByDescription(@PathVariable("description") String description) {
		LocationVO location = adlocations.remove(description); 
		
		if (location != null) {
			logger.info("Inside deleteLocationByDescription, deleted: " + location.toString());
		} else {
			logger.info("Inside deleteLocationByDescription, description: " + description + ", NOT FOUND!");
		}
		return location;
	}

	@RequestMapping(value="/location/create", method=RequestMethod.GET)
	public ModelAndView addLocation() {
		//redirect to page .jsp /WEB-INF/views/addLocation.jsp
		//cannot put @ResponseBody because DispatcherServlet have to find page .JSP
		return new ModelAndView("addLocation", "command", new LocationVO());
	}
	
	@RequestMapping(value="/location/addLocation", method=RequestMethod.POST)
	@ResponseBody
	public LocationVO addLocation(@ModelAttribute("location") LocationVO location) {
		
		if (location != null) {
			logger.info("Inside addLocation, adding: " + location.toString());
		} else {
			logger.info("Inside addLocation...");
		}
		adlocations.put(location.getDescription(), location);
		return location;
		
	}
	
}
