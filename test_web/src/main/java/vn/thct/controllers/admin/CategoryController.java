package vn.thct.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.thct.services.impl.CategoryServiceImpl;
import vn.thct.models.category_model;
import vn.thct.services.ICategoryService;
import vn.thct.utils.Constant;


@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = {"/admin/categories", "/admin/category/add", "/admin/category/insert", "/admin/category/edit", "/admin/category/update",
		"/admin/category/delete", "/admin/category/search"})
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public ICategoryService cateService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTf-8");
		resp.setCharacterEncoding("UTf-8");
		if(url.contains("categories")) {
			List<category_model> list = cateService.getAll();
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		}
		else if (url.contains("add")) {
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
		}
		else if(url.contains("edit") ) {
			int id = Integer.parseInt(req.getParameter("id"));
			category_model category = cateService.findById(id);
			req.setAttribute("cate", category);
			req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
		}
		else if(url.contains("delete") ) {
			int id = Integer.parseInt(req.getParameter("id"));
			cateService.delete(id);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTf-8");
		resp.setCharacterEncoding("UTf-8");
		if(url.contains("insert")) {
			category_model category = new category_model();
			String categoryname = req.getParameter("categoryname");
			int status = Integer.parseInt(req.getParameter("status"));
			category.setCategoryname(categoryname);
			category.setStatus(status);
			
			String fname ="";
			String uploadPath = Constant.DIR;
			File uploadDir = new File(uploadPath);
			if(!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part =req.getPart("images");
				if(part.getSize()>0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					// rename
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index+1);
					fname = System.currentTimeMillis() + "." + ext;
					//upload
					part.write(uploadPath+ "/" + fname);
					// write to database
					category.setImage(fname);
				} else {
					category.setImage("avatar.png");
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			cateService.insert(category);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
		else if (url.contains("update")){
			category_model category = new category_model();
			int categoryid = Integer.parseInt(req.getParameter("categoryid"));
			String categoryname = req.getParameter("categoryname");
			String status = req.getParameter("status");
			int statuss = Integer.parseInt(status);
			category.setCategoryid(categoryid);
			category.setCategoryname(categoryname);
			category.setStatus(statuss);
			
			category_model cateOld = cateService.findById(categoryid);
			String fileOld = cateOld.getImage();
			
			
			
			String fname ="";
			String uploadPath = Constant.DIR;
			File uploadDir = new File(uploadPath);
			if(!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part =req.getPart("images");
				if(part.getSize()>0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					// rename
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index+1);
					fname = System.currentTimeMillis() + "." + ext;
					//upload
					part.write(uploadPath+ "/" + fname);
					// write to database
					category.setImage(fname);
				} else {
					category.setImage(fileOld);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			cateService.edit(category);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
		
	}

}
