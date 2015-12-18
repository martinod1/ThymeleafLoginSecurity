package ie.cit.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import ie.cit.domain.ChObject;
import ie.cit.domain.Image;

@Repository
@Qualifier("ObjectRepository")
public class ObjectRepositoryImpl implements ObjectRepository {

	
	private SessionFactory sessionFactory;


	private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	public ObjectRepositoryImpl()
	{
		
	}

	  public ObjectRepositoryImpl(SessionFactory sessionFactory) {
			
			this.sessionFactory = sessionFactory;
		}

	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

  
    @ModelAttribute("hello")
	@Transactional
	public List<ChObject> findAll() {
		//setSessionFactory(sessionFactory);
	//	sessionFactory=new Configuration().configure().buildSessionFactory();
		//Session session = getSessionFactory().getCurrentSession();

		Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

		List<ChObject> objects = session.createCriteria(ChObject.class).list();;
		//session.getTransaction().commit();
		session.close();
	
	return objects;
	}

	@Transactional
	@ModelAttribute("gallery")
	public ChObject findById(Long id) {

		Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

		ChObject object= (ChObject) session.get(ChObject.class, id);
		//session.getTransaction().commit();
		session.close();
	
	return object;
	}

	@Override
	public List<Image> findAllImagesByObjectID(String object_id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		List<Image> images = (List<Image>) session.get(Image.class, object_id);
        session.close();

		return images;
	}



}
