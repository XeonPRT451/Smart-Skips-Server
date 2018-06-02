package cdu.xeon.smartskips.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="t_driver")
public class Driver {
	private int id;
	private String username;
	private String password;
	private String nickname;
	private String email;
	private String phone;
	private int status;
	private Date createDate;
	private int loaded;
	private int type;
	private double trashamount;
	

	public Driver(int id, String username, String password, String nickname,
			String email, String phone, int status, int loaded, int typy) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.status = status;
		this.loaded=loaded;
		this.type=type;
	}
	


	public Driver() {
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@NotNull(message="The user name cannot be empty")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@NotNull(message="User passwords cannot be empty")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Email(message="The mail format is incorrect")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Column(name="create_date")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public int getLoaded() {
		return loaded;
	}



	public void setLoaded(int loaded) {
		this.loaded = loaded;
	}



	public int getType() {
		return type;
	}



	public void setType(int type) {
		this.type = type;
	}



	public double getTrashamount() {
		return trashamount;
	}



	public void setTrashamount(double trashamount) {
		this.trashamount = trashamount;
	}



	@Override
	public String toString() {
		return "Driver [id=" + id + ", username=" + username + ", password=" + password + ", nickname=" + nickname
				+ ", email=" + email + ", phone=" + phone + ", status=" + status + ", createDate=" + createDate
				+ ", loaded=" + loaded + ", type=" + type + ", trashamount=" + trashamount + "]";
	}
	
	


	
	
	
	
	
	
}
