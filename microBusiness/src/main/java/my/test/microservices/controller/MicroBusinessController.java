package my.test.microservices.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //utilisé afin de mettre à jour la conf après un refresh
public class MicroBusinessController {
	@Value("${message.value}")
	private String message;
	
	@RequestMapping(value = "/message", method= RequestMethod.GET)
	public String getMessage() throws Exception{
		return message+" microBusiness !";
	}
}
