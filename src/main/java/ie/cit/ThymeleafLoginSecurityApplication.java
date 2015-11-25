package ie.cit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ie.cit.repository.ObjectRepository;
import ie.cit.service.ObjectService;
//import ie.cit.repository.UserRedisRepository;
//import ie.cit.service.FindChObjectImpl;
import ie.cit.service.ObjectServiceImpl;

@SpringBootApplication
public class ThymeleafLoginSecurityApplication implements CommandLineRunner {

	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	//UserRedisRepository userRepo = (UserRedisRepository)context.getBean("userRepo");
	
	//ObjectServiceImpl ch = (ObjectServiceImpl)context.getBean("ChObjectService");
	//@Autowired
	//ObjectService obj;

	ObjectRepository obj = context.getBean(ObjectRepository.class);

//	
	

	//ObjectRepository obj;
	
    public static void main(String[] args) {
        SpringApplication.run(ThymeleafLoginSecurityApplication.class, args);
    }
    
    @Override
    public void run(String ... arg0) throws Exception
    {
    	    	addUser();
    	
    }
    public void addUser() {
    	System.out.println("in add user");
    	System.out.println(obj.findAll().toString());
    //	System.out.println(obj.getObjects().toString());
    	//userRepo.add("larkin", "password1234");
    }
}
