package vn.thct.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.thct._implement.IUserService;
import vn.thct._interface.UserService;
import vn.thct.models.User;
import vn.thct.utils.Constant;

@SuppressWarnings("serial")
@WebServlet("/reset_passwd")
public class reset_passwd_controller extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/reset_passwd.jsp").forward(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String new_password = req.getParameter("new_password");
		String confirm_password = req.getParameter("confirm_password");
		String alertMsg = "";
		if (username.isEmpty() || new_password.isEmpty() || confirm_password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/reset_passwd.jsp").forward(req, resp);
			return;
		}

		if (!new_password.equals(confirm_password)) {
			alertMsg = "Vui long nhap lai mat khau de tiep tuc";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/reset_passwd.jsp").forward(req, resp);
			return;
		}

		UserService service = new IUserService();

		if (!service.checkExistUsername(username)) {
			alertMsg = "Tài khoản khong tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
			return;
		}

		boolean isSuccess = service.reset_passwd(new_password, username);
		if (isSuccess) {
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			alertMsg = "System error!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);

		}
	}

}
