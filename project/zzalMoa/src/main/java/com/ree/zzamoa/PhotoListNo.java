package com.ree.zzamoa;

import java.math.BigDecimal;

public class PhotoListNo {
	private BigDecimal start;
	private BigDecimal end;
	
	public PhotoListNo() {
		// TODO Auto-generated constructor stub
	}

	public PhotoListNo(BigDecimal start, BigDecimal end) {
		super();
		this.start = start;
		this.end = end;
	}

	public BigDecimal getStart() {
		return start;
	}

	public void setStart(BigDecimal start) {
		this.start = start;
	}

	public BigDecimal getEnd() {
		return end;
	}

	public void setEnd(BigDecimal end) {
		this.end = end;
	}
	
}
