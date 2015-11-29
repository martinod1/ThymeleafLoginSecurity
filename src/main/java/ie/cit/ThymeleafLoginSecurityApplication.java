package ie.cit;

import java.net.UnknownHostException;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import ie.cit.domain.UserDet;
import ie.cit.repository.ObjectRepository;
import ie.cit.repository.UserRepository;
import ie.cit.service.ObjectService;
//import ie.cit.repository.UserRedisRepository;
//import ie.cit.service.FindChObjectImpl;
import ie.cit.service.ObjectServiceImpl;
import ie.cit.service.UserService;
import ie.cit.service.UserServiceImpl;

@SpringBootApplication
public class ThymeleafLoginSecurityApplication implements CommandLineRunner {

	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	//UserRedisRepository userRepo = (UserRedisRepository)context.getBean("userRepo");
	
	//ObjectServiceImpl ch = (ObjectServiceImpl)context.getBean("ChObjectService");
	//@Autowired
	//ObjectService obj;

	ObjectRepository obj = context.getBean(ObjectRepository.class);
	
	//UserService user = context.getBean(UserService.class);
	
	@Autowired
	UserServiceImpl simp;
	//UserRepository user=context.getBean(UserRepository.class);
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
    	
    	UserDet usr =new UserDet();
    	usr.setId("rthybgvfr");
    	usr.setPassword("passw");;
    	usr.setRole("USER");
    	usr.setUsername("myusername");
    	simp.insert(usr);
    	
    	UserDet u = simp.findByUsername("martin");
    	/*UserDet us = new UserDet();
    	UserDet u1 = simp.findByUsername("user");
    	if(u1!=null)
    	{
        	System.out.println(u1.toString());

    	}
    	else
    	{
    		System.out.println("user 1 is null");
    	}
    	UserDet u = user.findByUsername("user");
    	*/
    	if(u!=null)
    	{
        	System.out.println(u.toString());

    	}
    	else
    	{
    		System.out.println("user is null save new user");
    	}
    	//User u = new User("Martin", "password1234");
    	//u.setUsername("Martin");
    	//u.setPassword("password1234");
    //	user.create(u);
    	System.out.println(obj.findAll().toString());
    //	System.out.println(obj.getObjects().toString());
    	//userRepo.add("larkin", "password1234");
    }
}
