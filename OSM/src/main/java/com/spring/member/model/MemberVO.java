package com.spring.member.model;

import java.io.Serializable;

public class MemberVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String year, month, date;
	private String gender;

	public MemberVO() {
		// TODO Auto-generated constructor stub
	}

	public MemberVO(String year, String month, String date, String gender) {
		this.year = year;
		this.month = month;
		this.date = date;
		this.gender = gender;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
