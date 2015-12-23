package ie.cit.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Document(collection="users")
public class UserDet {
	
	@Id
	private String id;
	
    private String username;

    private String password;

	public String role;
	
	public Integer points;
	
	public ArrayList<String> badges;
	
	public ArrayList<String> likes;
	
	public ArrayList<UserComment> comments;
	
	
	public ArrayList<UserComment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<UserComment> comments) {
		this.comments = comments;
	}

    public ArrayList<String> getLikes() {
		return likes;
	}

	public void setLikes(ArrayList<String> likes) {
		this.likes = likes;
	}

	public ArrayList<String> getBadges() {
		return badges;
	}

	public void setBadges(ArrayList<String> badges) {
		this.badges = badges;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDet [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", points=" + points + ", badges=" + badges + ", likes=" + likes + ", comments=" + comments + "]";
	}

	
	

	

	
	
	

}
