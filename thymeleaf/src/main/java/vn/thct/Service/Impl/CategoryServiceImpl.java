package vn.thct.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.thct.Entity.CategoryEntity;
import vn.thct.Repository.CategoryRepository;
import vn.thct.Service.ICategoryService;

//khai báo service
@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	CategoryRepository categoryRepository;

//source -> Generate Constructor using Field, xoa super()
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public <S extends CategoryEntity> S save(S entity) {
		if (entity.getCategoryId() == null) {
			return categoryRepository.save(entity);
		} else {
			Optional<CategoryEntity> opt = findById(entity.getCategoryId());
			if (opt.isPresent()) {
				if (StringUtils.isEmpty(entity.getName())) {
					entity.setName(opt.get().getName());
				} else {
//lấy lai images cũ
					entity.setName(entity.getName());
				}
			}
		}

		return categoryRepository.save(entity);
	}

	@Override
	public List<CategoryEntity> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Page<CategoryEntity> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	public List<CategoryEntity> findAll(Sort sort) {
		return categoryRepository.findAll(sort);
	}

	@Override
	public List<CategoryEntity> findAllById(Iterable<Long> ids) {
		return categoryRepository.findAllById(ids);
	}

	@Override
	public Optional<CategoryEntity> findById(Long id) {
		return categoryRepository.findById(id);
	}

	public <S extends CategoryEntity> Optional<S> findOne(Example<S> example) {
		return categoryRepository.findOne(example);
	}

	@Override
	public long count() {
		return categoryRepository.count();

	}

	@Override
	public Page<CategoryEntity> findByNameContaining(String name, Pageable pageable) {
	    return categoryRepository.findByNameContaining(name, pageable);
	}

	@Override
	public void deleteById(Long id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CategoryEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<CategoryEntity> findById(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<CategoryEntity> findByNameContaining(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CategoryEntity> findByName(String name) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
}
