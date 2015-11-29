/*package ie.cit.security;

import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import ie.cit.domain.UserDet;

@Service
public class MongoDBAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider  {

	 @Autowired
	    private MongoCollection users;

	    @Override
	    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
	    }

	    @Override
	    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
	        UserDetails loadedUser;

	        try {
	            UserDet user = users.findOne("{#: #}", UserDet.USERNAME, username).as(UserDet.class);
	            loadedUser = new User(user.getUsername(), user.getPassword(), user.getRoles());
	        } catch (Exception repositoryProblem) {
	            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
	        }

	        if (loadedUser == null) {
	            throw new InternalAuthenticationServiceException(
	                    "UserDetailsService returned null, which is an interface contract violation");
	        }
	        return loadedUser;
	    }

}
*/