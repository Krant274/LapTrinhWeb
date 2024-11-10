package vn.thct.models;

import java.io.Serializable;

public class video_model implements Serializable {
	private static final long serialVersionUID = 1L;
	private int videoid;
	private String videoname;
	private String video;
	private int status;

	public video_model() {
		super();
	}

	public int getVideoid() {
		return videoid;
	}

	public void setVideoid(int videoid) {
		this.videoid = videoid;
	}

	public String getVideoname() {
		return videoname;
	}

	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
