package ie.cit.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.cit.domain.UserComment;
import ie.cit.domain.UserDet;
import ie.cit.service.UserServiceImpl;

@Controller
public class RegistrationController {
	

	@Autowired
	UserServiceImpl userService;
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registrationSubmit(Model model, @ModelAttribute UserDet user)
	{
	
		UserDet u = userService.findByUsername(user.getUsername());
		if(u!=null)
		{
			return("registration");

		}
		else
		{
			ArrayList<String> badges = new ArrayList();
			ArrayList<String> likes = new ArrayList();
			ArrayList<UserComment> comments = new ArrayList();

			user.setRole("USER");
			user.setPoints(0);
			user.badges=badges;
			user.likes=likes;
			user.comments=comments;
			userService.insert(user);
			model.addAttribute("user", user);
			return("registrationSuccess");
		}
		
		
	}
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String registrationForm(Model model) {
		model.addAttribute("user", new UserDet());
		return "registration";
	}
	

}
