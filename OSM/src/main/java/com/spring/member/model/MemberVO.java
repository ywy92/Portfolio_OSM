package com.spring.member.model;

import java.util.Calendar;

public class MemberVO{

	private String year, month, date;
	private String gender;

	public MemberVO() {
	}
	public MemberVO(String year, String month, String date, String gender) {
		System.out.println("year:"+year);
		System.out.println("month:"+month);
		System.out.println("date:"+date);
		System.out.println("gender:"+gender);
		this.year = year;
		this.month = month;
		this.date = date;
		this.gender = gender;
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
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return year+"-"+month+"-"+date;
	}
	public int getAge() {
		Calendar c = Calendar.getInstance();
		return (c.get(Calendar.YEAR) - Integer.parseInt(year))+1;
	}
	public char getGender() {
		return gender == null ? '1':'0';
	}
}
