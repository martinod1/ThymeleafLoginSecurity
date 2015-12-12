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

	
	public Like createLike(Like like1) {
		System.out.println("within createLike");
		return like.insert(like1);
	}

	
	public Like updateLike(Integer objectid) {
		Like l = like.findOne(objectid);
		//Like l = like.findByObjectid(objectid);
		int amount = l.getAmount();
		amount++;
		l.setAmount(amount);
		System.out.println(l.toString());
		l.set_id(objectid);
		like.delete(l);
		//like.delete(objectid);
		//like.delete(l);
		like.insert(l);
		
		/*Like u = like.save(l);
		System.out.println(u.toString() + " gfsf");*/
		//like.insert(l);
		/*ArrayList<Like> entites = new ArrayList();
		entites.add(l);
		Iterator<Like>likes = entites.listIterator(0);
		//like.sa
		like.save(l);*/
		//like.save
		//like.save(l);
		//like.save(l);
		return l;
	}

	

}
