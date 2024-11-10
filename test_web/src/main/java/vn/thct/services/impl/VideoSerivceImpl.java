package vn.thct.services.impl;

import java.util.List;

import vn.thct.dao.IVideoDao;
import vn.thct.dao.impl.VideoDaoImpl;
import vn.thct.models.video_model;
import vn.thct.services.IVideoService;

public class VideoSerivceImpl implements IVideoService {

	IVideoDao videoDao = new VideoDaoImpl();
	
	@Override
	public void insert(video_model video) {
		videoDao.insert(video);
		
	}

	@Override
	public void edit(video_model video) {
		videoDao.edit(video);
		
	}

	@Override
	public void delete(int id) {
		videoDao.delete(id);
		
	}

	@Override
	public video_model findById(int id) {
		video_model video = videoDao.findById(id);
		return video;
	}

	@Override
	public video_model findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<video_model> getAll() {
		List<video_model> videos = videoDao.findAll();
		return videos;
	}

	@Override
	public List<video_model> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
