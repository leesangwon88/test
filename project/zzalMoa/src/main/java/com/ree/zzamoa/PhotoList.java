package com.ree.zzamoa;

import java.math.BigDecimal;
import java.util.Date;

public class PhotoList {
	private BigDecimal pl_number;
	private String pl_photo;
	private String pl_thumbnail;
	private String pl_tag;
	private String pl_view;
	private Date pl_date;
	
	public PhotoList() {
		// TODO Auto-generated constructor stub
	}
	
	public PhotoList(BigDecimal pl_number, String pl_photo, String pl_thumbnail, String pl_tag, String pl_view,
			Date pl_date) {
		super();
		this.pl_number = pl_number;
		this.pl_photo = pl_photo;
		this.pl_thumbnail = pl_thumbnail;
		this.pl_tag = pl_tag;
		this.pl_view = pl_view;
		this.pl_date = pl_date;
	}

	public BigDecimal getPl_number() {
		return pl_number;
	}

	public void setPl_number(BigDecimal pl_number) {
		this.pl_number = pl_number;
	}

	public String getPl_photo() {
		return pl_photo;
	}

	public void setPl_photo(String pl_photo) {
		this.pl_photo = pl_photo;
	}

	public String getPl_thumbnail() {
		return pl_thumbnail;
	}

	public void setPl_thumbnail(String pl_thumbnail) {
		this.pl_thumbnail = pl_thumbnail;
	}

	public String getPl_tag() {
		return pl_tag;
	}

	public void setPl_tag(String pl_tag) {
		this.pl_tag = pl_tag;
	}

	public String getPl_view() {
		return pl_view;
	}

	public void setPl_view(String pl_view) {
		this.pl_view = pl_view;
	}

	public Date getPl_date() {
		return pl_date;
	}

	public void setPl_date(Date pl_date) {
		this.pl_date = pl_date;
	}
	
}
