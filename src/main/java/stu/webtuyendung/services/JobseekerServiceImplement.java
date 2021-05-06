package stu.webtuyendung.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stu.webtuyendung.models.Jobseeker;
import stu.webtuyendung.repositories.JobseekerRepository;

@Service
public class JobseekerServiceImplement implements JobseekerService{
	@Autowired
	JobseekerRepository jobseekerRepo;

	@Override
	public Jobseeker save(Jobseeker entity) {
		return jobseekerRepo.save(entity);
	}

	@Override
	public  List<Jobseeker> saveAll(List<Jobseeker> entities) {
		return (List<Jobseeker>)jobseekerRepo.saveAll(entities);
	}

	@Override
	public Optional<Jobseeker> findById(String id) {
		return jobseekerRepo.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return jobseekerRepo.existsById(id);
	}

	@Override
	public List<Jobseeker> findAll() {
		return (List<Jobseeker>)jobseekerRepo.findAll();
	}

	@Override
	public List<Jobseeker> findAllById(List<String> ids) {
		return (List<Jobseeker>)jobseekerRepo.findAllById(ids);
	}

	@Override
	public long count() {
		return jobseekerRepo.count();
	}

	@Override
	public void deleteById(String id) {
		jobseekerRepo.deleteById(id);
	}

	@Override
	public void delete(Jobseeker entity) {
		jobseekerRepo.delete(entity);
	}

	@Override
	public void deleteAll(List<Jobseeker> entities) {
		jobseekerRepo.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		jobseekerRepo.deleteAll();
	}
	
	@Override
	public boolean checkLoginJobseeker(String email, String password) {
		Optional<Jobseeker> optionalJobseeker = findById(email);
		if(optionalJobseeker.isPresent() && optionalJobseeker.get().getPassword().equals(password))
		{
			return true;
		}
		return false;
	}
	
	
	
	
}
