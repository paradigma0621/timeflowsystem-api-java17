package com.timeflow.apijava17.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("somewhere")
public class LoadBalancerTester {

	@Autowired
	private Environment environment;

	@Autowired
	private PersonExternal personExternal;

	@GetMapping(value = "/testLoadBalancer")
	public String sayHello() {
		long sum = 0;

		for (int i=0; i<999999999; i++) {
			sum += i;
		}

		var port = environment.getProperty("local.server.port");

		String makeAFeign = personExternal.getPersonNameFromCore();

		String msg = makeAFeign + "Hello, Oswaldo in port " + port + "!!";
		return msg;
	}
	
	/**@GetMapping(value = "/{id}/{currency}")	
	public Book findBook(
			@PathVariable("id") Long id,
			@PathVariable("currency") String currency
			) {
		
		var book = repository.getById(id);
		if (book == null) throw new RuntimeException("Book not Found");
		
		HashMap<String, String> params = new HashMap<>();
		params.put("amount", book.getPrice().toString());
		params.put("from", "USD");
		params.put("to", currency);
		
		var response = new RestTemplate()
				.getForEntity("http://localhost:8000/cambio-service/"
						+ "{amount}/{from}/{to}", 
						Cambio.class,
						params);
		
		var cambio = response.getBody();
		
		var port = environment.getProperty("local.server.port");
		book.setEnvironment(port);
		book.setPrice(cambio.getConvertedValue());
		return book;
	}*/
}
