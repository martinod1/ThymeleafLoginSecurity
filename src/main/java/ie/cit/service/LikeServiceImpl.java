package ie.cit.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.domain.Like;
import ie.cit.repository.LikeRepository;

@Service
public class LikeServiceImpl implements LikeService {
	
	@Autowired
	private LikeRepository like;
	
	@Autowired
	private UserServiceImpl userService;

	@Override
	public Like createLike(Like like1) {
		System.out.println("within createLike");
		return like.insert(like1);
	}

	@Override
	public Like updateLike(Integer objectid) {
		Like l = like.findOne(objectid);
		int amount = l.getAmount();
		amount++;
		l.setAmount(amount);
		l.set_id(objectid);
		System.out.println(l.toString());
		userService.findByUsername("james");
		
		//like.delete(objectid);
		//l.set_id(32453678);
		like.save(l);
	
		return l;
	}

	@Override
	public Like updateContents(Like newLike) {
		//Like oldLike = like.findOne(newLike.get_id());
		//Integer id = newLike.get_id();
		//System.out.println(newLike.toString());
		//System.out.println(id);
		//like.delete(id);
		//like.delete(id);
		//System.out.println(id + " -----");

		return like.save(newLike);
	}

	
	

}
