package stu.webtuyendung.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import stu.webtuyendung.models.Congviec;
import stu.webtuyendung.repositories.CongviecRepository;



@Service
public class CongviecServiceImplement implements CongviecService{
	
	

	@Override
	public Page<Congviec> findAll(Pageable pageable) {
		return congviecRepo.findAll(pageable);
	}
	
	@Autowired
	CongviecRepository congviecRepo;
	
	@Override
	public Congviec save(Congviec entity) {
		return congviecRepo.save(entity);
	}

	@Override
	public List<Congviec> saveAll(List<Congviec> entities) {
		return (List<Congviec>)congviecRepo.saveAll(entities);
	}

	@Override
	public Optional<Congviec> findById(Long id) {
		return congviecRepo.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return congviecRepo.existsById(id);
	}

	@Override
	public List<Congviec> findAll() {
		return (List<Congviec>)congviecRepo.findAll();
	}

	@Override
	public List<Congviec> findAllById(List<Long> ids) {
		return (List<Congviec>)congviecRepo.findAllById(ids);
	}

	@Override
	public long count() {
		return congviecRepo.count();
	}

	@Override
	public void deleteById(Long id) {
		congviecRepo.deleteById(id);
	}

	@Override
	public void delete(Congviec entity) {
		congviecRepo.delete(entity);
	}

	@Override
	public void deleteAll(List<Congviec> entities) {
		congviecRepo.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		congviecRepo.deleteAll();
	}
	
	
	
	
	
}
