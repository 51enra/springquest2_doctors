package com.wildcodeschool.springquest2_doctors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class Springquest2DoctorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springquest2DoctorsApplication.class, args);
	}
	
	

	    @RequestMapping("/doctor/{incarnationNumber}")
	    @ResponseBody
	    public String index(@PathVariable int incarnationNumber) {
	    	String answer = "Empy message";
	    	String[] docs = new String[]
	    			{"Christopher Eccleston", "David Tennant", "Matt Smith", "Peter Capaldi", "Jodie Whittaker"};
	    	if (incarnationNumber>0 && incarnationNumber<9) {
	    		throw new ResponseStatusException(HttpStatus.SEE_OTHER, answer = "Undefined");	    		
	    	}
	    	if (incarnationNumber>8 && incarnationNumber<14) {
	    		answer = "{\"number\": "+ incarnationNumber+", \"name\": \"" + docs[incarnationNumber-9] +"\"}\n";
	    	} else {
	    		throw new ResponseStatusException(HttpStatus.NOT_FOUND,
	    				answer = "Impossible to retrieve the incarnation " + incarnationNumber);
	    	}
	    	return answer;
	    	
	    }
}