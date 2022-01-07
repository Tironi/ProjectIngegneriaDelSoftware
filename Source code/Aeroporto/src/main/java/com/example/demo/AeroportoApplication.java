package com.example.demo;
import com.example.demo.models.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AeroportoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AeroportoApplication.class, args);
	}
<<<<<<< Updated upstream

=======
	
	@GetMapping
	public String hello() {
		Aereo aereo = new Aereo(01, 2);
		return aereo.toString();
	}
	
>>>>>>> Stashed changes
}
