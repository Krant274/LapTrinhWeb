package vn.thct.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import vn.thct.Entity.CategoryEntity;

public interface ICategoryService {
	void deleteAll();

	void delete(CategoryEntity entity);

	void deleteById(Long id);

	Optional<CategoryEntity> findById(long id);

	<S extends CategoryEntity> S save(S entity);

	List<CategoryEntity> findAll();

	Page<CategoryEntity> findAll(Pageable pageable);

	List<CategoryEntity> findAll(Sort sort);

	List<CategoryEntity> findAllById(Iterable<Long> ids);

	Optional<CategoryEntity> findById(Long id);

	<S extends CategoryEntity> Optional<S> findOne(Example<S> example);

	List<CategoryEntity> findByNameContaining(String name);

	Page<CategoryEntity> findByNameContaining(String name, Pageable pageable);

	Optional<CategoryEntity> findByName(String name);

	long count();
}
