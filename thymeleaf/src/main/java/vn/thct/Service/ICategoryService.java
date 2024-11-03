package vn.thct.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import vn.thct.Entity.CategoryEntity;

public interface ICategoryService {
	<S extends CategoryEntity> S save(S entity);

	List<CategoryEntity> findAll();

	Page<CategoryEntity> findAll(Pageable pageable);

	List<CategoryEntity> findAll(Sort sort);

	List<CategoryEntity> findAllById(Iterable<Long> ids);

	Optional<CategoryEntity> findById(Long id);

	<S extends CategoryEntity> Optional<S> findOne(Example<S> example);

	void deleteById(Long id);

	Page<CategoryEntity> findByNameContaining(String name, Pageable pageable);

	long count();
}
