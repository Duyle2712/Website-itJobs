package stu.webtuyendung.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stu.webtuyendung.models.Recruiter;
import stu.webtuyendung.repositories.RecruiterRepository;

@Service
public class RecruiterServiceImplement implements RecruiterService{

	@Autowired
	RecruiterRepository recruiterRepo;
	
	@Override
	public Recruiter save(Recruiter entity) {
		return recruiterRepo.save(entity);
	}

	@Override
	public List<Recruiter> saveAll(List<Recruiter> entities) {
		return (List<Recruiter>)recruiterRepo.saveAll(entities);
	}

	@Override
	public Optional<Recruiter> findById(String id) {
		return recruiterRepo.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return recruiterRepo.existsById(id);
	}

	@Override
	public Iterable<Recruiter> findAll() {
		return recruiterRepo.findAll();
	}

	@Override
	public List<Recruiter> findAllById(List<String> ids) {
		return (List<Recruiter>)recruiterRepo.findAllById(ids);
	}

	@Override
	public long count() {
		return recruiterRepo.count();
	}

	@Override
	public void deleteById(String id) {
		recruiterRepo.deleteById(id);
	}

	@Override
	public void delete(Recruiter entity) {
		recruiterRepo.delete(entity);
	}

	@Override
	public void deleteAll(List<Recruiter> entities) {
		recruiterRepo.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		recruiterRepo.deleteAll();
	}

	
	
	
}
