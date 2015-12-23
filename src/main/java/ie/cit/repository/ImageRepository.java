package ie.cit.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import ie.cit.domain.Image;

public interface ImageRepository {
	
	List<Image> findAll();
	Image findByObjectID(Long object_id);

}
