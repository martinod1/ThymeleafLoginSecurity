package ie.cit.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="likes")
public class Like {
	
	
	@Id
	private Integer _id;
	
	private Integer amount;
	
	private  ArrayList<Comment> comments;
	

	public ArrayList<Comment> getComments() {
		return comments;
	}


	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	
	public Integer getAmount() {
		return amount;
	}

	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
		this._id = _id;
	}

	@Override
	public String toString() {
		return "Like [_id=" + _id + ", amount=" + amount + ", comments=" + comments + "]";
	}

	
	

	

	

}
