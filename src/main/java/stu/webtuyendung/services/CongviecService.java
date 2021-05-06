package stu.webtuyendung.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import stu.webtuyendung.models.Congviec;

public interface CongviecService {

	void deleteAll();

	void deleteAll(List<Congviec> entities);

	void delete(Congviec entity);

	void deleteById(Long id);

	long count();

	List<Congviec> findAllById(List<Long> ids);

	List<Congviec> findAll();

	boolean existsById(Long id);

	Optional<Congviec> findById(Long id);

	List<Congviec> saveAll(List<Congviec> entities);

	Congviec save(Congviec entity);

	Page<Congviec> findAll(Pageable pageable);


}
