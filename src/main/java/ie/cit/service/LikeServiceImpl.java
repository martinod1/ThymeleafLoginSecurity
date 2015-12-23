package ie.cit.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.domain.Like;
import ie.cit.repository.LikeRepository;

@Service
public class LikeServiceImpl implements LikeService {
	
	@Autowired
	private LikeRepository like;
	
	@Override
	public Like createLike(Like like1) {
		return like.insert(like1);
	}

	@Override
	public Like updateLike(Integer objectid) {
		Like l = like.findOne(objectid);
		int amount = l.getAmount();
		amount++;
		l.setAmount(amount);
		l.set_id(objectid);
		
		like.save(l);
	
		return l;
	}

	@Override
	public Like updateContents(Like newLike) {
		return like.save(newLike);
	}

}
