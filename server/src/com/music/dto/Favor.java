package com.music.dto;

public class Favor {
	int id,songid;
	String userid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSongid() {
		return songid;
	}
	public void setSongid(int songid) {
		this.songid = songid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Favor(int id, String userid,int songid ) {
		super();
		this.id = id;
		this.songid = songid;
		this.userid = userid;
	}
	public Favor( String userid,int songid) {
		super();
		this.songid = songid;
		this.userid = userid;
	}

	
	
	
}
