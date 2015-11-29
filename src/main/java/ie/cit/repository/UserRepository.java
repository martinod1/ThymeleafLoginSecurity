package ie.cit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ie.cit.domain.UserDet;

public interface UserRepository extends MongoRepository<UserDet, String>{
	
	//public void saveUser(UserDet u);
	public UserDet findByUsername(String name);

}
