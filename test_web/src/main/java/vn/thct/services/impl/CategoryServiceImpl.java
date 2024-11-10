package vn.thct.services.impl;

import java.util.List;

import vn.thct.dao.ICategoryDao;
import vn.thct.dao.impl.CategoryDaoImpl;
import vn.thct.models.category_model;
import vn.thct.services.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {

	ICategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public void insert(category_model category) {
		categoryDao.insert(category);

	}

	@Override
	public void edit(category_model category) {
		categoryDao.edit(category);

	}

	@Override
	public void delete(int id) {
		categoryDao.delete(id);

	}

	@Override
	public category_model findById(int id) {
		category_model category = categoryDao.findById(id);
		return category;
	}

	@Override
	public category_model findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<category_model> getAll() {
		List<category_model> category_list = categoryDao.findAll();
		return category_list;
	}

	@Override
	public List<category_model> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
}
