package stu.webtuyendung.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stu.webtuyendung.models.Admin;
import stu.webtuyendung.repositories.AdminRepository;

@Service
public class AdminServiceImplement implements AdminService{


	@Autowired
	AdminRepository adminRepo;
	
	@Override
	public  Admin save(Admin entity) {
		return adminRepo.save(entity);
	}

	@Override
	public List<Admin> saveAll(List<Admin> entities) {
		return (List<Admin>)adminRepo.saveAll(entities);
	}

	@Override
	public Optional<Admin> findById(String id) {
		return adminRepo.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return adminRepo.existsById(id);
	}

	@Override
	public List<Admin> findAll() {
		return (List<Admin>)adminRepo.findAll();
	}

	@Override
	public List<Admin> findAllById(List<String> ids) {
		return (List<Admin>)adminRepo.findAllById(ids);
	}

	@Override
	public long count() {
		return adminRepo.count();
	}

	
	@Override
	public boolean checkLoginAdmin(String username, String password) {
		Optional<Admin> optionalAdmin = findById(username);
		if(optionalAdmin.isPresent() && optionalAdmin.get().getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	
//	@Override
//	public String getFullnameByUsername(String username) {
//		return adminRepo.getFullnameByUsername(username);
//	}

	
	
	
}
