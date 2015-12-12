package ie.cit.domain;

public class Comment {
	
	String comment;
	String author;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Comment [comment=" + comment + ", author=" + author + "]";
	}
	

}
