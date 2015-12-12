package ie.cit.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import groovyjarjarantlr.collections.List;
import ie.cit.domain.ChObject;
import ie.cit.domain.Comment;
import ie.cit.domain.Like;
import ie.cit.repository.LikeRepository;
import ie.cit.repository.ObjectRepository;
import ie.cit.service.LikeServiceImpl;

@Controller
public class ObjectController {
	
	@Autowired
	LikeServiceImpl like;
	
	@Autowired
	LikeRepository l;
	
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	
	ObjectRepository obj = context.getBean(ObjectRepository.class);
	
	@RequestMapping(value = "/object/{id}", method=RequestMethod.GET)
	public String findByID(Model model, @PathVariable long id)
	{
		//id=(long) 68250611;
		model.addAttribute("object", obj.findById(id));
		int id1 = (int) id;
		if(l.findOne(id1) != null)
		{
			
			model.addAttribute("like", l.findOne(id1));
		}
		else
		{
			Like newLike = new Like();
			newLike.set_id(id1);
			newLike.setAmount(0);
			like.createLike(newLike);
			model.addAttribute("like", newLike);
		}
		model.addAttribute("comment", new Comment());

	//	System.out.println("---");
	//	System.out.println(obj.findById(id).toString());
		return("object");
	}
	
	@RequestMapping(value="/object/{id}/like", method=RequestMethod.GET)
	public String like(Model model, @PathVariable Integer id )
	{
		long id1 = id;
		
		
		//if not null - already exists - bump up value by 1
		/*if(l.findOne(id) != null)
		{
			Like updatedLike = like.updateLike(id);
			System.out.println("Returned like = " + updatedLike.toString());
			
			l.delete(id);
			l.insert(updatedLike);

			//l.save(updatedLike);
		}*/
		//no like already existing - therefore create one
		//else
		{
			like.updateLike(id);
			
	
		}
		
		model.addAttribute("comment", new Comment());

		model.addAttribute("like", l.findOne(id));
	
		model.addAttribute("object", obj.findById(id1));

		
		return("object");
	}
	@RequestMapping(value="/object/{id}/comment", method=RequestMethod.POST)
	public String processComments(Model model, @PathVariable long id, @ModelAttribute(value="comment") Comment comment)
	{
		comment.setAuthor("Martin");
		int id1 = (int) id;
		Like lik = l.findOne(id1);
		//List comments = (List) lik.getComments();
		ArrayList<Comment> comments = new ArrayList<Comment>();
		comments.add(comment);
		lik.setComments((java.util.List<Comment>) comments);
		//l.insert(lik);
		l.save(lik);
		
		model.addAttribute("comment", comment);
		
		model.addAttribute("object", obj.findById(id));
		model.addAttribute("like", l.findOne(id1));

		
		
		return "object";
	}

}
