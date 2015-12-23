package ie.cit.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ie.cit.domain.ChObject;
import ie.cit.domain.Image;

public interface ObjectRepository {

	List<ChObject> findAll();
	ChObject findById(Long id);
	
}
