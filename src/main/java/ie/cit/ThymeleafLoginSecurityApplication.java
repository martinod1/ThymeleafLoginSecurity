package ie.cit;

import java.net.UnknownHostException;
import java.util.List;

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

import ie.cit.domain.Image;
import ie.cit.domain.UserDet;
import ie.cit.repository.ImageRepository;
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

	/*ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	//UserRedisRepository userRepo = (UserRedisRepository)context.getBean("userRepo");
	
	//ObjectServiceImpl ch = (ObjectServiceImpl)context.getBean("ChObjectService");
	//@Autowired
	//ObjectService obj;

	ObjectRepository obj = context.getBean(ObjectRepository.class);
	
	ImageRepository img = context.getBean(ImageRepository.class);

	
	//UserService user = context.getBean(UserService.class);
	
	@Autowired
	UserServiceImpl simp;
	//UserRepository user=context.getBean(UserRepository.class);
//	
	

	//ObjectRepository obj;
*/	
    public static void main(String[] args) {
        SpringApplication.run(ThymeleafLoginSecurityApplication.class, args);
    }
    
    @Override
    public void run(String ... arg0) throws Exception
    {
    	    	
    	
    }
 
    
}
