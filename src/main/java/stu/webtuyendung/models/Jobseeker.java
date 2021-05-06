package stu.webtuyendung.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_jobseeker")
public class Jobseeker implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @Column(length = 50)
    private String email;
     
    @Column(nullable = false, length = 250)
    private String password;
    
    @Column(length = 50)
    private String fullname;
    
    @Column(length = 50)
    private String phone;

	public Jobseeker() {
		super();
	}

	public Jobseeker(String email, String password, String fullname, String phone) {
		super();
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
    
}
