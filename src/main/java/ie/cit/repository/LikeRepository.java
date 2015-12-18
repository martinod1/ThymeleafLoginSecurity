package ie.cit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ie.cit.domain.Like;


@Repository
public interface LikeRepository extends MongoRepository<Like, Integer> {

	@SuppressWarnings("unchecked")
	Like save(Like like);
	void delete(Integer _id);
	

}
