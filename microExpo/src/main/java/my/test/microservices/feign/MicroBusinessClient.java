package my.test.microservices.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("microBusiness")
public interface MicroBusinessClient {

	@RequestMapping(value="/message", method=RequestMethod.GET)
	@ResponseBody
	String getMessage();
}
