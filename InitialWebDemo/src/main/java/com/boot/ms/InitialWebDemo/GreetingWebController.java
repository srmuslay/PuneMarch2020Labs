package com.boot.ms.InitialWebDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingWebController {

	@GetMapping("/webgreet")
	public String defViewname(ModelAndView mv) {
		mv.addObject("greeting","Hello Corona");
		return "index";
	}
}
