package ie.cit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Image {

	@Id
	@Column
	private Long id;
	@Column
	private String url;
	@Column
	private Integer width;
	@Column
	private Integer height;
	@Column
	private Integer is_primary;
	@Column
	private Integer image_id;
	@Column
	private Integer object_id;
	@Column
	private String keyVal;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getIs_primary() {
		return is_primary;
	}
	public void setIs_primary(Integer is_primary) {
		this.is_primary = is_primary;
	}
	public Integer getImage_id() {
		return image_id;
	}
	public void setImage_id(Integer image_id) {
		this.image_id = image_id;
	}
	public Integer getObject_id() {
		return object_id;
	}
	public void setObject_id(Integer object_id) {
		this.object_id = object_id;
	}
	public String getKeyVal() {
		return keyVal;
	}
	public void setKeyVal(String keyVal) {
		this.keyVal = keyVal;
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", url=" + url + ", width=" + width + ", height=" + height + ", is_primary="
				+ is_primary + ", image_id=" + image_id + ", object_id=" + object_id + ", keyVal=" + keyVal + "]";
	}
	
	

	

}
