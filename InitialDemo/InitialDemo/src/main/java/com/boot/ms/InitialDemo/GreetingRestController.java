package com.boot.ms.InitialDemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {

	@RequestMapping(path = "/greet/default")
	public String getDefGreeting() {
		return "Hello Corona";
	}

}
