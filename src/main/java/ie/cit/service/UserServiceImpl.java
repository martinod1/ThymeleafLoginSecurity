package ie.cit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.domain.UserDet;
import ie.cit.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;

	public UserDet insert(UserDet user) {
		
		return repo.save(user);
		
	}
	
	@Override
	public UserDet createUser(UserDet user) {
		return repo.insert(user);
	}

	@Override
	public UserDet findByUsername(String username) {
		
		return repo.findByUsername(username);
		
	}

	@Override
	public List<UserDet> findAllUsers() {
		
		return repo.findAll();
	}

}
