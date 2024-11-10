package vn.thct.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.thct.connections.DBConnection;
import vn.thct.dao.IVideoDao;
import vn.thct.models.category_model;
import vn.thct.models.video_model;

public class VideoDaoImpl extends DBConnection implements IVideoDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public void insert(video_model video) {
		String sql = "INSERT INTO videos(videoname, video, status) VALUES (?,?,?)";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, video.getVideoname());
			ps.setString(2, video.getVideo());
			ps.setInt(3, video.getStatus());

			ps.executeUpdate();
			System.out.println("User inserted successfully.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void edit(video_model video) {
		String sql = "UPDATE videos SET videoname = ?, video=? WHERE videoid = ?";
		try {
			Connection con = super.getDatabaseConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, video.getVideoname());
			ps.setString(2, video.getVideo());
			ps.setInt(3, video.getVideoid());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM videos WHERE videoid = ?";
		try {
			Connection con = super.getDatabaseConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public video_model findById(int id) {
		String sql = "SELECT * FROM videos WHERE videoid = ?";
		try {
			Connection con = super.getDatabaseConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				video_model video = new video_model();
				video.setVideoid(rs.getInt("videoid"));
				video.setVideoname(rs.getString("videoname"));
				video.setVideo(rs.getString("video"));
				return video;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<video_model> findAll() {
		List<video_model> videos = new ArrayList<video_model>();
		String sql = "SELECT * FROM videos";
		try {
			Connection conn = super.getDatabaseConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				video_model video= new video_model();
				video.setVideoid(rs.getInt("videoid"));
				video.setVideoname(rs.getString("videoname"));
				video.setVideo(rs.getString("video"));
				video.setStatus(rs.getInt("status"));
				videos.add(video);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return videos;
	}

	@Override
	public List<video_model> findName(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
