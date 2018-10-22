package com.cafe24.iumium.schoolregister.studentinfo.dto;

public class HighSchool {
	private String studentNumber;	// 학번
	private String highSchoolSchoolName;	// 학교명
	private String highSchoolGraduation;	// 졸업일자
	
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getHighSchoolSchoolName() {
		return highSchoolSchoolName;
	}
	public void setHighSchoolSchoolName(String highSchoolSchoolName) {
		this.highSchoolSchoolName = highSchoolSchoolName;
	}
	public String getHighSchoolGraduation() {
		return highSchoolGraduation;
	}
	public void setHighSchoolGraduation(String highSchoolGraduation) {
		this.highSchoolGraduation = highSchoolGraduation;
	}
}
