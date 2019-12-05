package co.kr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	public String shop(Locale locale, Model model, HttpServletRequest request) {
		try {
			logger.info("shop call {}.", locale);
			String authorityId = request.getParameter("authorityid");
						
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://127.0.0.1:9220/controller/api/orders?authorityid="+authorityId, String.class);

			ObjectMapper mapper = new ObjectMapper();
			List<Object> jsonlist =  new ArrayList<Object>();
			jsonlist = mapper.readValue(responseEntity.getBody(), new TypeReference<ArrayList<Object>>(){});

			model.addAttribute("totalData", jsonlist);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "orders";
	}
	
}
