package vn.thct.services;

import java.util.List;

import vn.thct.models.category_model;

public interface ICategoryService {
	void insert(category_model category);

	void edit(category_model category);

	void delete(int id);

	category_model findById(int id);

	category_model findByName(String name);

	List<category_model> getAll();

	List<category_model> search(String keyword);
}
