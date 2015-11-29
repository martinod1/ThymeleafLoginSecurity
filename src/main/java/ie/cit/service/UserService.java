package ie.cit.service;

import ie.cit.domain.UserDet;

public interface UserService {

	UserDet createUser(UserDet user);
	UserDet findByUsername(String username);
}
