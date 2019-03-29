package com.ree.zzamoa;

public class Member {
	private String mb_id;
	private String mb_pw;
	private String mb_name;
	private String mb_photo;
	private String mb_master;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String mb_id, String mb_pw, String mb_name, String mb_photo, String mb_master) {
		super();
		this.mb_id = mb_id;
		this.mb_pw = mb_pw;
		this.mb_name = mb_name;
		this.mb_photo = mb_photo;
		this.mb_master = mb_master;
	}

	public String getMb_id() {
		return mb_id;
	}

	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}

	public String getMb_pw() {
		return mb_pw;
	}

	public void setMb_pw(String mb_pw) {
		this.mb_pw = mb_pw;
	}

	public String getMb_name() {
		return mb_name;
	}

	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}

	public String getMb_photo() {
		return mb_photo;
	}

	public void setMb_photo(String mb_photo) {
		this.mb_photo = mb_photo;
	}

	public String getMb_master() {
		return mb_master;
	}

	public void setMb_master(String mb_master) {
		this.mb_master = mb_master;
	}

}
