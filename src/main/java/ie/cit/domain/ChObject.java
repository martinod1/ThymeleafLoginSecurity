package ie.cit.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ChObject {
	
	@Id
	@Column
	private long id;
	
	//annotations from attempting to modify the code so that the objects would be saved in a cascading manner
	//i.e. chobject -> saves images + participations -> saves roles + participants
	//@ElementCollection
	//@OneToMany(mappedBy="chobj", cascade=CascadeType.ALL, orphanRemoval=true)
	//@JoinColumn(name="chobject_id")
	
	
	@Column
	private Integer object_id;
	@Column
	private String title;
	@Column
	private String date;
	
	@Column
	private String creditline;
	@Column
	private String description;
	@Column
	private String gallery_text;
	
	@Column
	private String medium;


	@Override
	public String toString() {
		return "ChObject [id=" + id + ", object_id=" + object_id + ", title=" + title + ", date=" + date
				+ ", creditline=" + creditline + ", description=" + description + ", gallery_text=" + gallery_text
				+ ", medium=" + medium + "]";
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Integer getObject_id() {
		return object_id;
	}


	public void setObject_id(Integer object_id) {
		this.object_id = object_id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getCreditline() {
		return creditline;
	}


	public void setCreditline(String creditline) {
		this.creditline = creditline;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getGallery_text() {
		return gallery_text;
	}


	public void setGallery_text(String gallery_text) {
		this.gallery_text = gallery_text;
	}


	public String getMedium() {
		return medium;
	}


	public void setMedium(String medium) {
		this.medium = medium;
	}
	

}
