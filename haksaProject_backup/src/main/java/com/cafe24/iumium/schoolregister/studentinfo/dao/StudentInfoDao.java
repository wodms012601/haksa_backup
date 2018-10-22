package com.cafe24.iumium.schoolregister.studentinfo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.iumium.common.dto.DepartmentCode;
import com.cafe24.iumium.lesson.lecture.dto.ClassByDepartment;
import com.cafe24.iumium.schoolregister.studentinfo.dto.Advice;
import com.cafe24.iumium.schoolregister.studentinfo.dto.ClassChange;
import com.cafe24.iumium.schoolregister.studentinfo.dto.Family;
import com.cafe24.iumium.schoolregister.studentinfo.dto.HighSchool;
import com.cafe24.iumium.schoolregister.studentinfo.dto.MyProfile;
import com.cafe24.iumium.schoolregister.studentinfo.dto.ScholarshipBenefit;
import com.cafe24.iumium.schoolregister.studentinfo.dto.StudentInfo;

@Repository
public class StudentInfoDao {

	@Autowired	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String nameSpace = "com.cafe24.iumium.schoolregister.studentinfo.dao.StudentInfoMapper.";
	
	//학과 코드 불러오기
	public List<DepartmentCode> selectDeptCodeList() {
		System.out.println("학과 코드 Dao");
		return sqlSessionTemplate.selectList(nameSpace + "getDeptCodeList");
	}
	
	//학년 불러오기
	public List<DepartmentCode> selectgradeList(DepartmentCode departmentCode) {
		System.out.println("학년 Dao");
		List<DepartmentCode> list = new ArrayList<DepartmentCode>();
		DepartmentCode grade = sqlSessionTemplate.selectOne(nameSpace + "getgradeList", departmentCode);
		int j = grade.getDeptGraduatedGrade();
		
		for(int i=0; i<j; i++) {
			grade.setDeptGraduatedGrade(i+1);
			list.add(grade);
		}
		return list;
	}
	
	//반 불러오기
	public List<String> selectdepartmentClassList(DepartmentCode department) {
		System.out.println("반 Dao");
		List<ClassByDepartment> classByDepartmentList = sqlSessionTemplate.selectList(nameSpace + "getdepartmentClassList", department);
		List<String> list = new ArrayList<String>();
		String className = null;
		
		for(int i=0; i<classByDepartmentList.size(); i++) {
			className = classByDepartmentList.get(i).getClassByDepartmentClass();
			list.add(className);
		}
		
		TreeSet<String> list2 = new TreeSet<String>(list);
		list = new ArrayList<String>(list2);
		
		return list;
	}
	
	// 학생정보 리스트
	public List<StudentInfo> selectStudentInfoList(StudentInfo studentInfo) {
		System.out.println("학생정보 리스트 Dao");
		return sqlSessionTemplate.selectList(nameSpace + "getStudentInfoList", studentInfo);
	}
	
	// 졸업학과 null 값 체크
	public int selectgraduationDepartment(String studentNumber) {
		System.out.println("졸업학과 null 값 체크 Dao");
		return sqlSessionTemplate.selectOne(nameSpace + "getgraduationDepartment", studentNumber);
	}
	
	// 졸업학과 null 값일 때 1명의 학생정보 조회
	public StudentInfo selectStudentInfoNull(String studentNumber) {
		System.out.println("졸업학과 null 값일 때 1명의 학생정보 Dao");
		return sqlSessionTemplate.selectOne(nameSpace + "getStudentInfoNull", studentNumber);
	}
	
	// 졸업학과 null 값이 아닐 때 1명의 학생정보 조회
	public StudentInfo selectStudentInfo(String studentNumber) {
		System.out.println("졸업학과 null 값이 아닐 때 1명의 학생정보 Dao");
		return sqlSessionTemplate.selectOne(nameSpace + "getStudentInfo", studentNumber);
	}
	
	// 장학금 수혜내역 리스트
	public List<ScholarshipBenefit> selectScholarshipBenefitList() {
		System.out.println("장학금 수혜내역 Dao");
		return sqlSessionTemplate.selectList(nameSpace + "getScholarshipBenefitList");
	}
	
	// 상담 리스트
	public List<Advice> selectAdviceList() {
		System.out.println("상담 Dao");
		return sqlSessionTemplate.selectList(nameSpace + "getAdviceList");
	}
	
	// 반 변경 리스트
	public List<ClassChange> selectClassChangeList() {
		System.out.println("반 변경 Dao");
		return sqlSessionTemplate.selectList(nameSpace + "getClassChangeList");
	}
	
	//  학생 1명의 장학금 수혜내역
	public List<ScholarshipBenefit> selectScholarshipBenefit(String studentNumber) {
		System.out.println("학생 1명의 장학금 수혜내역 Dao");
		return sqlSessionTemplate.selectList(nameSpace + "getScholarshipBenefit", studentNumber);
	}
	
	//  학생 1명의 상담내역
	public List<Advice> selectAdvice(String studentNumber) {
		System.out.println("학생 1명의 상담내역 Dao");
		return sqlSessionTemplate.selectList(nameSpace + "getAdvice", studentNumber);
	}
	
	//  학생 1명의 반 변경 내역
	public List<ClassChange> selectClassChange(String studentNumber) {
		System.out.println("학생 1명의 반 변경 내역 Dao");
		return sqlSessionTemplate.selectList(nameSpace + "getClassChange", studentNumber);
	}
	
	//  학생 1명의 가족사항
	public List<Family> selectFamily(String studentNumber) {
		System.out.println("학생 1명의 가족사항 Dao");
		return sqlSessionTemplate.selectList(nameSpace + "getFamily", studentNumber);
	}
	
	// 학생 1명의 신상명세사항
	public MyProfile selectMyProfile(String studentNumber) {
		System.out.println("학생 1명의 신상명세사항 Dao");
		return sqlSessionTemplate.selectOne(nameSpace + "getMyProfile", studentNumber);
	}
	
	// 학생 1명의 고등학력사항
	public HighSchool selectHighSchool(String studentNumber) {
		System.out.println("학생 1명의 고등학력사항 Dao");
		return sqlSessionTemplate.selectOne(nameSpace + "getHighSchool", studentNumber);
	}
	
	// 국가 코드 불러오기
	public List<StudentInfo> selectCountryCode() {
		System.out.println("국가 코드 불러오기 Dao");
		return sqlSessionTemplate.selectList(nameSpace + "getCountryCode");
	}
	
	// 학번 중복 체크
	public int selectStudentNumber(StudentInfo studentInfo) {
		System.out.println("학번 중복체크 Dao");
		return sqlSessionTemplate.selectOne(nameSpace + "getStudentNumber", studentInfo);
	}
	
	// 학과별 반 번호 조회
	public StudentInfo selectClassByDepartment(StudentInfo studentInfo) {
		System.out.println("학과별 반 번호 조회 Dao");
		return sqlSessionTemplate.selectOne(nameSpace + "getClassByDepartment", studentInfo);
	}
	
	// 학생정보 입력
	public StudentInfo insertStudentInfo(StudentInfo studentInfo) {
		System.out.println("학생정보 입력 Dao");
		return sqlSessionTemplate.selectOne(nameSpace + "getinsertStudentInfo", studentInfo);
	}
	
	// 인적사항 입력
	public StudentInfo insertHuman(StudentInfo studentInfo) {
		System.out.println("인적사항 입력 Dao");
		return sqlSessionTemplate.selectOne(nameSpace + "getinsertHuman", studentInfo);
	}
}
