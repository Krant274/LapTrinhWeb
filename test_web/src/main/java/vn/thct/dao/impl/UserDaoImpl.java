package vn.thct.dao.impl;

import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.thct.connections.DBConnection;
import vn.thct.dao.IUserDao;
import vn.thct.models.user_model;

public class UserDaoImpl extends DBConnection implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<user_model> findAll() {
		String sql = "select * from users";
		List<user_model> list = new ArrayList<>();

		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new user_model(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getString("image"), rs.getString("fullname"), rs.getInt("roleid"),
						rs.getDate("createDate")));
			}

			return list;

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	@Override
	public user_model findById(int id) {
		String sql = "Select * from users where id = ? ";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return new user_model(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getString("image"), rs.getString("fullname"), rs.getInt("roleid"),
						rs.getDate("createDate"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public void insert(user_model user) {
		String sql = "INSERT INTO users(username, password, email, image, fullname, createDate) VALUES(?,?,?,?,?,?)";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getImage());
			ps.setString(5, user.getFullname());
			ps.setDate(6, user.getCreatDate());
			ps.executeUpdate();
			System.out.println("User inserted successfully.");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public user_model findByUserName(String username) {
		String sql = "Select * from users where username = ? ";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				user_model user = new user_model();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setImage(rs.getString("image"));
				user.setRoleid(rs.getInt("roleid"));
				user.setCreatDate(rs.getDate("createDate"));
				return user;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static void main(String[] args) {
		UserDaoImpl userDao = new UserDaoImpl();
		// userDao.insert(new user_model("abc", "abc", "abc@email.com", "image",
		// "abc"));
		System.out.println(userDao.findByUserName("thctan"));
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String sql = "select * from users where email = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String sql = "select * from users where username = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return duplicate;
	}

	@Override
	public boolean changePassword(String username, String password) {
		String sql = "UPDATE users SET password = ? WHERE username = ?";
	    try {
	        conn = super.getDatabaseConnection();
	        ps = conn.prepareStatement(sql);
	        
	        // Set parameters
	        ps.setString(1, password); // New password
	        ps.setString(2, username); // Username
	        ps.execute();
	        return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}


}
