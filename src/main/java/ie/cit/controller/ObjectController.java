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
import ie.cit.domain.Image;
import ie.cit.domain.Like;
import ie.cit.domain.UserComment;
import ie.cit.domain.UserDet;
import ie.cit.repository.ImageRepository;
import ie.cit.repository.LikeRepository;
import ie.cit.repository.ObjectRepository;
import ie.cit.service.LikeServiceImpl;
import ie.cit.service.UserServiceImpl;

@Controller
public class ObjectController {
	
	@Autowired
	LikeServiceImpl like;
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	LikeRepository l;
	
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	
	ObjectRepository obj = context.getBean(ObjectRepository.class);
	ImageRepository img = context.getBean(ImageRepository.class);

	@RequestMapping(value = "/object/{id}", method=RequestMethod.GET)
	public String findByID(Model model, @PathVariable long id)
	{

		model.addAttribute("object", obj.findById(id));
		int id1 = (int) id;
		if(l.findOne(id1) != null)
		{
			model.addAttribute("like", l.findOne(id1));
			ArrayList<Comment> comments = new ArrayList<Comment>();
			comments = l.findOne(id1).getComments();
			if(comments==null)
			{
				comments = new ArrayList<Comment>();
			}
			
			model.addAttribute("comments", comments);
			model.addAttribute("comment", new Comment());


		}
		else
		{

			Like newLike = new Like();
			newLike.set_id(id1);
			newLike.setAmount(0);
			ArrayList<Comment> comments = new ArrayList<Comment>();
			newLike.setComments(comments);
			like.createLike(newLike);
			model.addAttribute("like", newLike);
			model.addAttribute("comment", new Comment());
			model.addAttribute("comments", comments);

		}
		
		Image i = img.findByObjectID(id);
		model.addAttribute("image", i);
	
		return("object");
	}
	
	@RequestMapping(value="/object/{id}/like", method=RequestMethod.GET)
	public String like(Model model, @PathVariable Integer id )
	{
			long id1 = id;
		
			like.updateLike(id);
			
			UserDet u = userService.findByUsername("martin");
			u.points++;
			u.likes.add(id.toString());
			
			String url = "http://mymoneymychoices.com/wp-content/uploads/2013/10/badge_";
			for(int i=10; i<130; i=i+10)
			{
				if(u.points>=i)
				{
					String url2 = url + ""+i/10+".png";
					if(u.badges!=null)
					{
						if(u.badges.contains(url2))
						{
							
						}
						else
						{
							System.out.println(url2 + " url reached");
							u.badges.add(url2);
						}
					}
					
					else
					{
						System.out.println(url2 + " url reached");
						u.badges.add(url2);

					}

				}
			}
			
			userService.insert(u);
			
		ArrayList<Comment> comments = new ArrayList<Comment>();
		comments = l.findOne(id).getComments();
		model.addAttribute("comments", comments);

		model.addAttribute("comment", new Comment());

		model.addAttribute("like", l.findOne(id));
	
		model.addAttribute("object", obj.findById(id1));
		
		Image i = img.findByObjectID(id1);
		model.addAttribute("image", i);

		
		return("object");
	}
	@RequestMapping(value="/object/{id}/comment", method=RequestMethod.POST)
	public String processComments(Model model, @PathVariable long id, @ModelAttribute(value="comment") Comment comment)
	{
		comment.setAuthor("martin");
		int id1 = (int) id;
		Like lik = l.findOne(id1);
		ArrayList<Comment> comments =(ArrayList<Comment>) lik.getComments();
		if(comments==null)
		{
			comments = new ArrayList();
			comments.add(comment);
		}
		else
		{
			comments.add(comment);
		}

		lik.setComments(comments);
		l.delete(lik);
		l.insert(lik);

		UserDet u = userService.findByUsername("martin");
		
		u.points++;
		UserComment com = new UserComment();
		com.setComment(comment.getComment());
		com.setObject_id(id1);
		ArrayList <UserComment> coms = u.getComments();
		coms.add(com);
		String url = "http://mymoneymychoices.com/wp-content/uploads/2013/10/badge_";

		for(int i=10; i<130; i=i+10)
		{

			if(u.points>=i)
			{
				String url2 = url + ""+i/10+".png";
				if(u.badges!=null)
				{
					if(u.badges.contains(url2))
					{
						
					}
					else
					{
						System.out.println(url2 + " url reached");
						u.badges.add(url2);
					}
				}
				else
				{
					System.out.println(url2 + " url reached");
					u.badges.add(url2);
				}
			}
		}

		userService.insert(u);
		
		model.addAttribute("comments", comments);
		model.addAttribute("comment", new Comment());
		model.addAttribute("object", obj.findById(id));
		model.addAttribute("like", l.findOne(id1));
		Image i = img.findByObjectID(id);
		model.addAttribute("image", i);

		return "object";
	}

}
