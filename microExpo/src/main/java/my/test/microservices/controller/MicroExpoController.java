package my.test.microservices.controller;

import my.test.microservices.feign.MicroBusinessClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MicroExpoController {
	
	@Value("${information.value}")
	private String information;

	@Autowired
	@Qualifier("hystrixWrappedBusinessClient")
	private MicroBusinessClient microBusinessClient;
	
	@RequestMapping(value="/message", method=RequestMethod.GET)
	public String getMessage(){
		return microBusinessClient.getMessage();
	}
	
	@RequestMapping(value="/information", method=RequestMethod.GET)
	@HystrixCommand
	public String getInformation(){
		return information+" microExpo";
	}
}
