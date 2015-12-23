package ie.cit.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.ModelAttribute;

import ie.cit.domain.Image;

public class ImageRepositoryImpl implements ImageRepository {
	
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	public ImageRepositoryImpl()
	{
		
	}

	  public ImageRepositoryImpl(SessionFactory sessionFactory) {
			
			this.sessionFactory = sessionFactory;
		}

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Transactional
	public List<Image> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        
        List<Image> images = session.createCriteria(Image.class).list();
        session.close();

        return images;
	}

   
	@Override
	@Transactional
	public Image findByObjectID(Long objectid) {
		
		Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
      
        String keyval = "b";
        String sql = "SELECT * FROM IMAGE WHERE object_id = :object_id AND keyval = :keyval";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Image.class);
        query.setParameter("object_id", objectid);
        query.setParameter("keyval", keyval);
        List results = query.list();
        System.out.println(results.size());
        System.out.println(results.get(0).toString());
        Image i = (Image) results.get(0);
       
        session.close();
		return  i;
		
	}

}
