package ie.cit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import ie.cit.domain.ChObject;
import ie.cit.domain.UserDet;
import ie.cit.repository.ImageRepository;
import ie.cit.repository.ObjectRepository;
import ie.cit.repository.UserRepository;
import ie.cit.service.ObjectService;
import ie.cit.service.UserService;
import ie.cit.service.UserServiceImpl;


@Controller
@EnableWebMvc
public class MainController {
	
	
	
	@Autowired
	UserServiceImpl userService;
	
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	
	ObjectRepository obj = context.getBean(ObjectRepository.class);
	ImageRepository img = context.getBean(ImageRepository.class);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "home";
	}
 
	@RequestMapping(value="/home", method =RequestMethod.GET)
	public String showObject(Model model)
	{
		model.addAttribute("objects", obj.findAll());
		return("home");
	}

	@RequestMapping(value = "/gallery", method=RequestMethod.GET)
	public String showObjects(Model model)
	{
		Long id = (long) 68250611;
		model.addAttribute("objects", obj.findAll());
		model.addAttribute("images", img.findByObjectID(id));
		return("gallery");
	}

	 // Login form
	  @RequestMapping(value="/login", method= RequestMethod.GET)
	  public String login() {
	    return "login";
	  }
	

}
