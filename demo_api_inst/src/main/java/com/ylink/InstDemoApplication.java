package com.ylink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class InstDemoApplication {
	/*@RequestMapping("/")
    public String greeting() {
        return "Hello World!";
    }*/
	
	public static void main(String[] args) {
		SpringApplication.run(InstDemoApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate(){
		RestTemplate restTemplate = new RestTemplate(new SimpleClientHttpRequestFactory());
		return restTemplate;
	}
}
