package com.boot.ms.InitialWebDemo;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingWebController {

	@GetMapping("/webgreet")
	public String defViewname(Model mv) {
		mv.addAttribute("greeting","Hello Corona @"+ new Date());
		return "index";
	}
}
