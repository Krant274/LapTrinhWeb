package vn.thct.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.thct.connections.DBConnection;
import vn.thct.dao.ICategoryDao;
import vn.thct.models.category_model;

public class CategoryDaoImpl extends DBConnection implements ICategoryDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public void insert(category_model category) {
		String sql = "INSERT INTO categories(categoryname, image, status) VALUES (?,?,?)";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImage());
			ps.setInt(3, category.getStatus());

			ps.executeUpdate();
			System.out.println("User inserted successfully.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void edit(category_model category) {
		String sql = "UPDATE categories SET categoryname = ?, image=? WHERE categoryid = ?";
		try {
			Connection con = super.getDatabaseConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImage());
			ps.setInt(3, category.getCategoryid());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM categories WHERE categoryid = ?";
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
	public category_model findById(int id) {
		String sql = "SELECT * FROM categories WHERE categoryid = ?";
		try {
			Connection con = super.getDatabaseConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				category_model category = new category_model();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImage(rs.getString("image"));
				return category;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<category_model> findAll() {
		List<category_model> categories = new ArrayList<category_model>();
		String sql = "SELECT * FROM categories";
		try {
			Connection conn = super.getDatabaseConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				category_model category = new category_model();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImage(rs.getString("image"));
				category.setStatus(rs.getInt("status"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public List<category_model> findName(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
