package com.ree.zzamoa;

import java.math.BigDecimal;

public class TagList {
	private BigDecimal tag_type;
	private String tag_list;

	public TagList() {
		// TODO Auto-generated constructor stub
	}

	public TagList(BigDecimal tag_type, String tag_list) {
		super();
		this.tag_type = tag_type;
		this.tag_list = tag_list;
	}

	public BigDecimal getTag_type() {
		return tag_type;
	}

	public void setTag_type(BigDecimal tag_type) {
		this.tag_type = tag_type;
	}

	public String getTag_list() {
		return tag_list;
	}

	public void setTag_list(String tag_list) {
		this.tag_list = tag_list;
	}
	
}
