package ie.cit.domain;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="likes")
public class Like {
	
	@Field("_id")
	@Id
	private Integer _id;
	
	private Integer amount;
	
	private List<Comment> comments;
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
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
