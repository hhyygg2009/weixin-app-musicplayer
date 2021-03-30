package com.music.dto;

public class Music {
	int id;
	String title,singer,src,coverImgUrl;
	
	public Music(int id, String title, String singer, String src, String coverImgUrl) {
		super();
		this.id = id;
		this.title = title;
		this.singer = singer;
		this.src = src;
		this.coverImgUrl = coverImgUrl;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getCoverImgUrl() {
		return coverImgUrl;
	}
	public void setCoverImgUrl(String coverImgUrl) {
		this.coverImgUrl = coverImgUrl;
	}
}
