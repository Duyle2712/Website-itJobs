package stu.webtuyendung.models;
import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "tbl_congviec")
public class Congviec implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="macv")
	private Long macv;
	
	@Column(name="chucdanh", length = 100)
	private String chucdanh;
	
	
	@Column(name="capbac", length = 50)
	private String capbac;
	
	@Column(name="loaicv")
	private int loaicv;
	
	@Column(name="diadiem", length = 250)
	private String diadiem;
	
	@Column(name="mota", length = 2000)
	private String mota;
	
	@Column(name="yeucau", length = 2000)
	private String yeucau;
	
	@Column(name="mucluong")
	private Long mucluong;
	
	@Column(name="ngonngu", length = 50)
	private String ngonngu;
	
	@Column(name="nguoilienhe", length = 50)
	private String nguoilienhe;
	
	@Column(name="status")
	private int status;
    
	
    @Column(name = "email")
	private String email;
	
	

	public Congviec() {
		super();
	}


	
	
	public Congviec(Long macv, String chucdanh, String capbac, int loaicv, String diadiem, String mota, String yeucau,
			Long mucluong, String ngonngu, String nguoilienhe, int status, String email) {
		super();
		this.macv = macv;
		this.chucdanh = chucdanh;
		this.capbac = capbac;
		this.loaicv = loaicv;
		this.diadiem = diadiem;
		this.mota = mota;
		this.yeucau = yeucau;
		this.mucluong = mucluong;
		this.ngonngu = ngonngu;
		this.nguoilienhe = nguoilienhe;
		this.status = status;
		this.email = email;
	}

	
	public Long getMacv() {
		return macv;
	}


	public void setMacv(Long macv) {
		this.macv = macv;
	}


	public String getChucdanh() {
		return chucdanh;
	}


	public void setChucdanh(String chucdanh) {
		this.chucdanh = chucdanh;
	}


	public String getCapbac() {
		return capbac;
	}


	public void setCapbac(String capbac) {
		this.capbac = capbac;
	}


	public int getLoaicv() {
		return loaicv;
	}


	public void setLoaicv(int loaicv) {
		this.loaicv = loaicv;
	}


	public String getDiadiem() {
		return diadiem;
	}


	public void setDiadiem(String diadiem) {
		this.diadiem = diadiem;
	}


	public String getMota() {
		return mota;
	}


	public void setMota(String mota) {
		this.mota = mota;
	}


	public String getYeucau() {
		return yeucau;
	}


	public void setYeucau(String yeucau) {
		this.yeucau = yeucau;
	}


	public Long getMucluong() {
		return mucluong;
	}


	public void setMucluong(Long mucluong) {
		this.mucluong = mucluong;
	}


	public String getNgonngu() {
		return ngonngu;
	}


	public void setNgonngu(String ngonngu) {
		this.ngonngu = ngonngu;
	}

	public String getNguoilienhe() {
		return nguoilienhe;
	}


	public void setNguoilienhe(String nguoilienhe) {
		this.nguoilienhe = nguoilienhe;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
