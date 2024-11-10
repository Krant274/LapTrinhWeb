package vn.thct.services.impl;

import java.util.List;

import vn.thct.dao.ICategoryDao;
import vn.thct.entity.Category;
import vn.thct.dao.impl.CategoryDaoImpl;
import vn.thct.services.ICategoryService;

public class CategoryServiceImpl implements ICategoryService{

	ICategoryDao cateDao = new CategoryDaoImpl();
	
	@Override
	public int count() {
		return cateDao.count();
	}

	@Override
	public List<Category> findAll(int page, int pagesize) {
		return cateDao.findAll();
	}

	@Override
	public List<Category> findByCategoryname(String catname) {
		return cateDao.findByCategoryname(catname);
	}

	@Override
	public List<Category> findAll() {
		return cateDao.findAll();
	}

	@Override
	public Category findById(int cateid) {
		return cateDao.findById(cateid);
	}

	@Override
	public void delete(int cateid) throws Exception {
		cateDao.delete(cateid);
		
	}

	@Override
	public void update(Category category) {
		cateDao.update(category);
		
	}

	@Override
	public void insert(Category category) {
		cateDao.insert(category);
		
	}

	
}
