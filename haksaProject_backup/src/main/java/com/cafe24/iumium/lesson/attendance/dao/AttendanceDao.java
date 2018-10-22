package com.cafe24.iumium.lesson.attendance.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.iumium.manage.lecture.dto.SubjectCode;

@Repository
public class AttendanceDao {
	private final String NS = "com.cafe24.iumium.lesson.attendance.dao.AttendanceMapper.";
	@Autowired private SqlSessionTemplate sqlSessionTemplate;
	
	// 과목 조회 쿼리문 실행
	public List<SubjectCode> subjectSearchList(String deptCode){
		return sqlSessionTemplate.selectList(NS+"getSubjectList", deptCode);
	}
	
	
}
