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
import vn.thct.models.video_model;
import vn.thct.services.IVideoService;
import vn.thct.services.impl.VideoSerivceImpl;
import vn.thct.utils.Constant;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = { "/admin/videos", "/admin/video/add", "/admin/video/insert", "/admin/video/edit",
		"/admin/video/update", "/admin/video/delete", "/admin/video/search" })
public class VideoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public IVideoService vidService = new VideoSerivceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTf-8");
		resp.setCharacterEncoding("UTf-8");
		if (url.contains("videos")) {
			List<video_model> list = vidService.getAll();
			req.setAttribute("listvid", list);
			req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);
		} else if (url.contains("add")) {
			req.getRequestDispatcher("/views/admin/video-add.jsp").forward(req, resp);
		} else if (url.contains("edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			video_model video = vidService.findById(id);
			req.setAttribute("vid", video);
			req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp);
		} else if (url.contains("delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			vidService.delete(id);
			resp.sendRedirect(req.getContextPath() + "/admin/videos");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		if (url.contains("insert")) {
			video_model video = new video_model();

			// Retrieve video properties from the request
			String videoName = req.getParameter("videoname");
			int status = Integer.parseInt(req.getParameter("status"));
			video.setVideoname(videoName);
			video.setStatus(status);

			// File upload handling
			String fname = "";
			String uploadPath = Constant.DIR;
			System.out.println("Upload path: " + uploadPath);
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}

			try {
				Part part = req.getPart("videofile");
				if (part != null && part.getSize() > 0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					String ext = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();

					// Ensure the uploaded file is an mp4 video
					if ("mp4".equals(ext)) {
						fname = System.currentTimeMillis() + "." + ext;
						part.write(uploadPath + "/" + fname);
						video.setVideoname(fname);
					} else {
						throw new ServletException("Invalid file type: only MP4 videos are allowed.");
					}
				} else {
					video.setVideoname("default-video.mp4"); // Placeholder if no file is uploaded
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			vidService.insert(video);
			resp.sendRedirect(req.getContextPath() + "/admin/videos");
		} else if (url.contains("update")) {
			video_model video = new video_model();

			// Retrieve video properties
			int videoId = Integer.parseInt(req.getParameter("videoId"));
			String videoName = req.getParameter("videoname");
			int status = Integer.parseInt(req.getParameter("status"));
			video.setVideoid(videoId);
			video.setVideoname(videoName);
			video.setStatus(status);

			video_model oldVideo = vidService.findById(videoId);
			String oldFile = oldVideo.getVideoname();

			String fname = "";
			String uploadPath = Constant.DIR;
			

			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}

			try {
				Part part = req.getPart("videoFile");
				if (part != null && part.getSize() > 0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					String ext = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();

					// Ensure the uploaded file is an mp4 video
					if ("mp4".equals(ext)) {
						fname = System.currentTimeMillis() + "." + ext;
						part.write(uploadPath + "/" + fname);
						video.setVideoname(fname);
					} else {
						throw new ServletException("Invalid file type: only MP4 videos are allowed.");
					}
				} else {
					video.setVideoname(oldFile); // Use the old file if no new file is uploaded
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			vidService.edit(video);
			resp.sendRedirect(req.getContextPath() + "/admin/videos");
		}
	}

}
