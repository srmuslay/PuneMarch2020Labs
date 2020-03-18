package com.boot.ms.InitialDemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {

	//@Value("${greetingDateFormat:h:mm a}")
	
	@Value("${greetingDateFormat:\"h:mm a\"}")
	private String dateFormat;

	@Autowired
	GreetingRepo repo;

	@RequestMapping(path = "/greet/default")
	public String getDefGreeting() {
		return "Hello Corona";
	}

	@RequestMapping(path = "/greet/{id}/{name}")
	public String getDbGreeting(@PathVariable Integer id, @PathVariable String name) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return repo.getOne(id).getSaying() + ", " + name + " [ " + sdf.format(new Date()) + " ] ";
	}

	@RequestMapping(path = "/greeting", method = RequestMethod.GET)
	public List<Greeting> getAllGreetings() {
		return repo.findAll();
	}

	@RequestMapping(path = "/greeting", method = RequestMethod.POST)
	public ResponseEntity<String> saveGreeting(@RequestBody Greeting greeting) {
		repo.save(greeting);
		return ResponseEntity.ok("Greeting Saved !");
	}
}
