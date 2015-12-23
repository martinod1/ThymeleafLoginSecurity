package ie.cit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ie.cit.domain.ChObject;

@Service
public interface ObjectService {
	public List<ChObject> getObjects();
}
