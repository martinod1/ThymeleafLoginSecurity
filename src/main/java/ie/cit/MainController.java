package ie.cit;

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
import ie.cit.repository.ObjectRepository;
import ie.cit.repository.UserRepository;
import ie.cit.service.ObjectService;
import ie.cit.service.UserService;
import ie.cit.service.UserServiceImpl;

//import ie.cit.repository.UserRedisRepository;


@Controller
@EnableWebMvc
public class MainController {
	
	/* @Autowired
	 private MongoCollection users;
	'*/
	
	@Autowired
	UserServiceImpl userService;
	
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	
	ObjectRepository obj = context.getBean(ObjectRepository.class);
	//UserRepository user = context.getBean(UserRepository.class);
	//UserRedisRepository userRepo = (UserRedisRepository)context.getBean("userRepo");
	
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
/*	//@Secured({"ROLE_USER"})
	@RequestMapping(value = "/gallery", method=RequestMethod.GET)
	public Map<String, Object> showObjects(@AuthenticationPrincipal UserDetails userDetails)
	{
		UserDet user =users.findOne("{#:#}", UserDet.USERNAME, userDetails.getUsername()).as(UserDet.class);
		 Map<String, Object> model = new HashMap<>();
	      model.put("roles", user.getRoles());
		((Model) model).addAttribute("objects", obj.findAll());
		return model;
	}*/
	@RequestMapping(value = "/gallery", method=RequestMethod.GET)
	public String showObjects(Model model)
	{
		model.addAttribute("objects", obj.findAll());
		return("gallery");
	}

	
	
	/*@RequestMapping(value="/object", method=RequestMethod.GET)
	public String object() {
		return "object";
	}*/
	/*public ModelAndView index() {
	//	String userName = userRepo.get("martin");
		ModelAndView modelAndView = new ModelAndView("hello");
		List<ChObject> objList = obj.findAll();

		modelAndView.addObject(objList);


		return modelAndView;
	}*/
	 // Login form
	  @RequestMapping(value="/login", method= RequestMethod.GET)
	  public String login() {
	    return "login";
	  }
	

}
