package vn.thct.services;

import java.util.List;

import vn.thct.models.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findALL();

	CategoryModel findById(int id);

	void insert(CategoryModel category);

	void update(CategoryModel category);

	void delete(int id);

	List<CategoryModel> findName(String keyword);
}
