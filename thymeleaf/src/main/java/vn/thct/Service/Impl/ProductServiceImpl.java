package vn.thct.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import vn.thct.Entity.ProductEntity;
import vn.thct.Repository.ProductRepository;
import vn.thct.Service.IProductService;

public class ProductServiceImpl implements IProductService {

	@Autowired
	ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public <S extends ProductEntity> S save(S entity) {
		if (entity.getProductId() == null) {
			return productRepository.save(entity);
		} else {
			Optional<ProductEntity> optImages = findById(entity.getProductId());
			if (optImages.isPresent()) {
				if (StringUtils.isEmpty(entity.getName())) {
					entity.setImages(optImages.get().getImages());
				} else {
//lấy lai images cũ
					entity.setImages(entity.getName());
				}
			}
			return productRepository.save(entity);
		}
	}

	@Override
	public List<ProductEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ProductEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductEntity> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductEntity> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ProductEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends ProductEntity> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<ProductEntity> findByNameContaining(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ProductEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<ProductEntity> findById(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<ProductEntity> findByNameContaining(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ProductEntity> findByName(String name) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
