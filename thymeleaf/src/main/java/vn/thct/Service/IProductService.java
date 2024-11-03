package vn.thct.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import vn.thct.Entity.ProductEntity;

public interface IProductService {
	void deleteAll();

	void delete(ProductEntity entity);

	void deleteById(Long id);

	Optional<ProductEntity> findById(long id);

	<S extends ProductEntity> S save(S entity);

	List<ProductEntity> findAll();

	Page<ProductEntity> findAll(Pageable pageable);

	List<ProductEntity> findAll(Sort sort);

	List<ProductEntity> findAllById(Iterable<Long> ids);

	Optional<ProductEntity> findById(Long id);

	<S extends ProductEntity> Optional<S> findOne(Example<S> example);

	List<ProductEntity> findByNameContaining(String name);

	Page<ProductEntity> findByNameContaining(String name, Pageable pageable);

	Optional<ProductEntity> findByName(String name);

	long count();

}
