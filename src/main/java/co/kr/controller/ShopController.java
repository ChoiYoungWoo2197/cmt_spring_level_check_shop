package co.kr.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ShopController {
	
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "orders" , method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//logger.info("shop call {}.", locale);
		System.out.println("shop before");
		
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://127.0.0.1:9220/controller/api/orders", String.class);


		System.out.println("shop after");
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("totalData", responseEntity.getBody() );
		
		return "home";
	}
	
}
