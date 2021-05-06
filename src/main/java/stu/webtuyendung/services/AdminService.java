package stu.webtuyendung.services;

import java.util.List;
import java.util.Optional;

import stu.webtuyendung.models.Admin;

public interface AdminService {

	boolean checkLoginAdmin(String username, String password);

	long count();

	List<Admin> findAllById(List<String> ids);

	List<Admin> findAll();

	boolean existsById(String id);

	Optional<Admin> findById(String id);

	List<Admin> saveAll(List<Admin> entities);

	Admin save(Admin entity);

//	String getFullnameByUsername(String username);
	

}
