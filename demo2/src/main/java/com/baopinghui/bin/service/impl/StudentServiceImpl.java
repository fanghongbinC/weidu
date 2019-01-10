package com.baopinghui.bin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baopinghui.bin.dto.ResultDto;
import com.baopinghui.bin.entity.ActiveEntity;
import com.baopinghui.bin.entity.CourseEntity;
import com.baopinghui.bin.entity.DianMianEntity;
import com.baopinghui.bin.entity.StudentEntity;
import com.baopinghui.bin.mapper.app.ActiveMapper;
import com.baopinghui.bin.mapper.app.CourseMapper;
import com.baopinghui.bin.mapper.app.StudentMapper;
import com.baopinghui.bin.service.ActiveService;
import com.baopinghui.bin.service.CourseService;
import com.baopinghui.bin.service.DianMianService;
import com.baopinghui.bin.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
    private StudentMapper studentMapper;

	@Override
	public Integer insertStudent(StudentEntity a) {
		// TODO Auto-generated method stub
		Integer rd=studentMapper.insertStudent(a);
		return rd;
	}

	@Override
	public Integer updateStudent(StudentEntity c) {
		// TODO Auto-generated method stub
		Integer a=studentMapper.updateStudent(c);
		return a;
	}

	@Override
	public Integer deleteStudent(int id) {
		// TODO Auto-generated method stub
		Integer a=studentMapper.deleteStudent(id);
		return a;
	}

	@Override
	public List<Map<String, Object>> selectStudent() {
		// TODO Auto-generated method stub
		 List<Map<String, Object>> a=studentMapper.selectStudent();
		return a;
	}



}
