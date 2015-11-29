/*package ie.cit.repository;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import ie.cit.domain.UserDet;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private MongoOperations mongoOps;
    private static final String USER_COLLECTION = "User";
    
    
	
    public UserRepositoryImpl()
    {
    	
    }
    public UserRepositoryImpl(MongoOperations mongoOps)
    {
    	this.mongoOps=mongoOps;
    }
    
	@Override
	public void create(UserDet u) {
        this.mongoOps.insert(u, USER_COLLECTION);
        System.out.println("created user ---" + u.toString());
	}
	@Override
	public void findUser(String name) {
		BasicDBObject query = new BasicDBObject("username", name);
		//DBCursor results = this.mongoOps.findAll(new BasicDBObject("username", name));
		//DBObject myDoc = this.mongoOps.find(query);
		
	}
	

}*/