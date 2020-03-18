package com.boot.ms.InitialDemo;

import java.net.Authenticator.RequestorType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {

	@Autowired
	GreetingRepo repo;

	@RequestMapping(path = "/greet/default")
	public String getDefGreeting() {
		return "Hello Corona";
	}

	@RequestMapping(path = "/greet/{id}/{name}")
	public String getDbGreeting(@PathVariable Integer id, @PathVariable String name) {
		return repo.getOne(id).getSaying() + ", " + name;
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
