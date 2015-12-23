package ie.cit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import ie.cit.domain.ChObject;
import ie.cit.repository.ObjectRepository;
import ie.cit.repository.ObjectRepositoryImpl;

@Service
@Transactional
@Qualifier("ChObjectService")
public class ObjectServiceImpl implements ObjectService {
	
	
	//@Autowired
	private ObjectRepository objRepo;


	@Override
	public List<ChObject> getObjects() {
		
		return objRepo.findAll();	}

	

}
