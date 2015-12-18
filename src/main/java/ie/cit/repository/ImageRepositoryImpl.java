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

    @ModelAttribute("hello")
	@Transactional
	public List<Image> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        
        List<Image> images = session.createCriteria(Image.class).list();
        session.close();

        return images;
	}

    @Transactional
	//@ModelAttribute("gallery")
	public Image findById(Long id) {
		
		Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        
        Image image= (Image) session.get(Image.class, id);
        session.close();

    	return image;
	}

	@Override
	public Image findByObjectID(Long objectid) {
		//ArrayList <Image> images = new ArrayList<Image>();
		
		Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        
      /*  Object o = session
                .createSQLQuery("Select * from image where object_id = ? and keyval = ?")
                .setParameter(0, objectid).setParameter(1, "sq").
		
        Object o = session
                .createSQLQuery("Select * from image where object_id = ? and keyval = ?")
                .setParameter(0, objectid).setParameter(1, "sq").uniqueResult();
        Image im = (Image) o;*/
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
        
        
       // System.out.println(i.getUrl());
       // System.out.println(i.getKeyVal());
        //Criteria criteria = session.createCriteria(Image.class);
        //Image image = (Image) criteria.add(Restrictions.eqOrIsNull("object_id", object_id)).uniqueResult();
        
        //Image objImage = (Image) session.get(Image.class, object_id);
        session.close();
		return  i;
		
	}

}
