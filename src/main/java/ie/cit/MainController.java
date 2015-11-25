package ie.cit;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import ie.cit.domain.ChObject;
import ie.cit.repository.ObjectRepository;
import ie.cit.service.ObjectService;

//import ie.cit.repository.UserRedisRepository;


@Controller
@EnableWebMvc
public class MainController {
	
	
	
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	
	ObjectRepository obj = context.getBean(ObjectRepository.class);

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
	@RequestMapping(value = "/gallery", method=RequestMethod.GET)
	public String showObjects(Model model)
	{
		model.addAttribute("objects", obj.findAll());
		return("gallery");
	}
	@RequestMapping(value = "/object/{id}", method=RequestMethod.GET)
	public String findByID(Model model, @PathVariable Long id)
	{
		//id=(long) 68250611;
		model.addAttribute("object", obj.findById(id));
	//	System.out.println("---");
	//	System.out.println(obj.findById(id).toString());
		return("object");
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