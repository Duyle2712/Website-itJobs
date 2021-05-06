package stu.webtuyendung.models;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

import java.io.Serializable;



@Entity
@Table(name = "tbl_recruiter")
public class Recruiter implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @Column(nullable = false, length = 50)
    private String email;
     
    @Column(nullable = false, length = 250)
    private String password;
     
	public Recruiter() {
		super();
	}


	public Recruiter(String email, String password) {
		super();
		this.email = email;
		this.password = password;
		
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



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
 
}
