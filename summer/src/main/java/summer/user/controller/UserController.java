package summer.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import summer.user.model.User;
import summer.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired private UserService userService;
	
	@GetMapping("/join")
	public String insert() {
		return "/user/join";
	}

	@GetMapping("/login")
	public String goLogin() {
		return "/user/login";
	}
	
	@PostMapping("/join")
	public String join(User user) {
		userService.create(user);
		return "/user/login";
    }
	
	@PostMapping("/login")
	public void login(User user) {
		userService.loadUserByUsername(user.getUsername());
    }
}
