package vn.thct.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.thct.dao.IUserDao;
import vn.thct.dao.impl.UserDaoImpl;
import vn.thct.services.IUserService;
import vn.thct.services.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/forgetpwd" })
public class ForgetPasswordController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IUserService service = new UserServiceImpl();
	IUserDao userDao = new UserDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/forget_password.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("uname");
		String password = req.getParameter("psw");
		String alertMsg = "";
		if (!userDao.checkExistUsername(username)) {
			alertMsg = "username was not found";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/forget_password.jsp").forward(req, resp);
	 		return;
		}
		boolean isSuccess = service.forget_password(username, password);
		if(isSuccess) {
			req.setAttribute("alert", alertMsg);
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			alertMsg = "System error!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/forgetpwd").forward(req, resp);
		}
	}

}
