package ie.cit.domain;

public class UserComment {


	
	String comment;
	Integer object_id;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "UserComment [comment=" + comment + ", object_id=" + object_id + "]";
	}
	public Integer getObject_id() {
		return object_id;
	}
	public void setObject_id(Integer object_id) {
		this.object_id = object_id;
	}
	
	

}
