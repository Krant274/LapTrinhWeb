package vn.thct.models;

import java.io.Serializable;
import java.sql.Date;

public class user_model implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private String email;
	private String image;
	private String fullname;
	private int roleid;
	private Date creatDate;

	public user_model() {
		super();
	}

	public user_model(int id, String username, String password, String email, String image, String fullname, int roleid,
			Date creatDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.image = image;
		this.fullname = fullname;
		this.roleid = roleid;
		this.creatDate = creatDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

	@Override
	public String toString() {
		return "user_model [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", image=" + image + ", fullname=" + fullname + ", roleid=" + roleid + ", creatDate=" + creatDate
				+ "]";
	}

}
