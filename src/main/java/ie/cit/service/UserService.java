package ie.cit.service;

import java.util.List;

import ie.cit.domain.UserDet;

public interface UserService {

	UserDet createUser(UserDet user);
	UserDet findByUsername(String username);
	List<UserDet> findAllUsers();
}
