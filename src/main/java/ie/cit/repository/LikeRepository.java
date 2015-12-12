package ie.cit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ie.cit.domain.Like;


@Repository
public interface LikeRepository extends MongoRepository<Like, Integer> {

	Like save(Like like);
	void delete(Integer _id);
	//public Like updateLike();
	//public Like addLike(Integer object_id);
	//public Like findByObjectid(Integer objectid);
	//public Like updateLike(Integer object_id);

}
