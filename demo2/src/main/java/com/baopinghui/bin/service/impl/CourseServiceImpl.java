package com.baopinghui.bin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baopinghui.bin.dto.ResultDto;
import com.baopinghui.bin.entity.CourseEntity;
import com.baopinghui.bin.entity.DianMianEntity;
import com.baopinghui.bin.mapper.app.CourseMapper;
import com.baopinghui.bin.service.CourseService;
import com.baopinghui.bin.service.DianMianService;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	@Autowired
    private CourseMapper courseMapper;

	@Override
	public Integer insertCourse(CourseEntity c) {
		// TODO Auto-generated method stub
		Integer rd=courseMapper.insertCourse(c);
		return rd;
	}

	@Override
	public Integer updateCourse(CourseEntity c) {
		// TODO Auto-generated method stub
		Integer a=courseMapper.updateCourse(c);
		return a;
	}

	@Override
	public Integer deleteCourse(int id) {
		// TODO Auto-generated method stub
		Integer a=courseMapper.deleteCourse(id);
		return a;
	}

	@Override
	public List<Map<String, Object>> selectCourse() {
		// TODO Auto-generated method stub
		 List<Map<String, Object>> a=courseMapper.selectCourse();
		return a;
	}



}
