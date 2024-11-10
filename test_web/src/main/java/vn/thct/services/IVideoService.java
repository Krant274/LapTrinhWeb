package vn.thct.services;

import java.util.List;

import vn.thct.models.video_model;

public interface IVideoService {
	void insert(video_model video);

	void edit(video_model video);

	void delete(int id);

	video_model findById(int id);

	video_model findByName(String name);

	List<video_model> getAll();

	List<video_model> search(String keyword);
}
