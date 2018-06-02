package cdu.xeon.smartskips.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="t_operator")
public class Operator {
	private int id;
	private String username;
	private String nickname;
	private String email;
	private String phone;
	private int status;
	private int onduty;
	private Date createDate;
	private Landfill landfill;
    private String lname;
	

	public Operator(int id, String username, String nickname, String email, String phone, int status, int onduty,
			Date createDate, String lname) {
		super();
		this.id = id;
		this.username = username;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.status = status;
		this.onduty = onduty;
		this.createDate = createDate;
		this.lname = lname;
	}
	
	public Operator(int id, String username, String nickname,
			String email, String phone, int status) {
		super();
		this.id = id;
		this.username = username;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.status = status;
	}
	public Operator() {
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
	
	@ManyToOne
	@JoinColumn(name="lid")
	public Landfill getLandfill() {
		return landfill;
	}
	public void setLandfill(Landfill landfill) {
		this.landfill = landfill;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getOnduty() {
		return onduty;
	}
	public void setOnduty(int onduty) {
		this.onduty = onduty;
	}
	
	
	
}
