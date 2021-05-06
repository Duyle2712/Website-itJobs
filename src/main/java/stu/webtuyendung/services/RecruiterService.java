package stu.webtuyendung.services;

import java.util.List;
import java.util.Optional;

import stu.webtuyendung.models.Recruiter;

public interface RecruiterService {

	void deleteAll();

	void deleteAll(List<Recruiter> entities);

	void delete(Recruiter entity);

	void deleteById(String id);

	long count();

	List<Recruiter> findAllById(List<String> ids);

	Iterable<Recruiter> findAll();

	boolean existsById(String id);

	Optional<Recruiter> findById(String id);

	List<Recruiter> saveAll(List<Recruiter> entities);

	Recruiter save(Recruiter entity);

}
