package stu.webtuyendung.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_admin")
public class Admin implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @Column(nullable = false, length = 50)
    private String username;
     
    @Column(nullable = false, length = 250)
    private String password;
     
    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

	public Admin() {
		super();
	}

	public Admin(String username, String password, String fullName) {
		super();
		this.username = username;
		this.password = password;
		this.fullName = fullName;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
    
}
