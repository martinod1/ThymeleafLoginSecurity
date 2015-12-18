package ie.cit.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import ie.cit.domain.Image;

public interface ImageRepository {
	
	List<Image> findAll();
	Image findById(Long id);
	Image findByObjectID(Long object_id);
	//Image findByObjectID(Long object_id);

}
