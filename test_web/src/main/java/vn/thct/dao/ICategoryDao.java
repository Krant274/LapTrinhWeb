package vn.thct.dao;

import java.util.List;

import vn.thct.models.category_model;

public interface ICategoryDao {
	void insert(category_model category);

	void edit(category_model category);

	void delete(int id);

	category_model findById(int id);

	List<category_model> findAll();

	List<category_model> findName(String keyword);
}
