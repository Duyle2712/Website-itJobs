package stu.webtuyendung.services;

import java.util.List;
import java.util.Optional;

import stu.webtuyendung.models.Jobseeker;

public interface JobseekerService {

	boolean checkLoginJobseeker(String email, String password);

	void deleteAll();

	void deleteAll(List<Jobseeker> entities);

	void delete(Jobseeker entity);

	void deleteById(String id);

	long count();

	List<Jobseeker> findAllById(List<String> ids);

	List<Jobseeker> findAll();

	boolean existsById(String id);

	Optional<Jobseeker> findById(String id);

	List<Jobseeker> saveAll(List<Jobseeker> entities);

	Jobseeker save(Jobseeker entity);

}
