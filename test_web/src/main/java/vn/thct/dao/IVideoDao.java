package vn.thct.dao;

import java.util.List;

import vn.thct.models.video_model;

public interface IVideoDao {
	void insert(video_model video);

	void edit(video_model video);

	void delete(int id);

	video_model findById(int id);

	List<video_model> findAll();

	List<video_model> findName(String keyword);
}
