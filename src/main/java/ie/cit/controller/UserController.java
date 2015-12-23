package ie.cit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.cit.domain.UserDet;
import ie.cit.service.UserServiceImpl;

@Controller
public class UserController {
	
	

	@Autowired
	UserServiceImpl userService;
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String registrationForm(Model model) {
		UserDet u = userService.findByUsername("martin");
		model.addAttribute("user", u);
		model.addAttribute("users", userService.findAllUsers());
		return "user";
	}

}
