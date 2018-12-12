package summer.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import summer.test.repository.TestRepository;

@Controller
public class TestController {

	@Autowired private TestRepository testRepository;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test() {
		System.out.println(testRepository.count());
	}
}
