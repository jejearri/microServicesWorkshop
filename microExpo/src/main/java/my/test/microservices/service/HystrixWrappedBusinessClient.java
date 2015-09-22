package my.test.microservices.service;

import my.test.microservices.feign.MicroBusinessClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service("hystrixWrappedBusinessClient")
public class HystrixWrappedBusinessClient implements MicroBusinessClient {
	
	@Autowired
	@Qualifier("microBusinessClient")
	private MicroBusinessClient businessClient;

	@Override
	@HystrixCommand(fallbackMethod="getMessageFallBack")
	public String getMessage() {
		return businessClient.getMessage();
	}

	public String getMessageFallBack(){
		return "non disponible";
	}
}
