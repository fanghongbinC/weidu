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
import com.baopinghui.bin.mapper.app.ActiveMapper;
import com.baopinghui.bin.mapper.app.CourseMapper;
import com.baopinghui.bin.service.ActiveService;
import com.baopinghui.bin.service.CourseService;
import com.baopinghui.bin.service.DianMianService;

@Service
@Transactional
public class ActiveServiceImpl implements ActiveService {
	@Autowired
    private ActiveMapper activeMapper;

	@Override
	public Integer insertActive(ActiveEntity a) {
		// TODO Auto-generated method stub
		Integer rd=activeMapper.insertActive(a);
		return rd;
	}

	@Override
	public Integer updateActive(ActiveEntity c) {
		// TODO Auto-generated method stub
		Integer a=activeMapper.updateActive(c);
		return a;
	}

	@Override
	public Integer deleteActive(int id) {
		// TODO Auto-generated method stub
		Integer a=activeMapper.deleteActive(id);
		return a;
	}

	@Override
	public List<Map<String, Object>> selectActive() {
		// TODO Auto-generated method stub
		 List<Map<String, Object>> a=activeMapper.selectActive();
		return a;
	}



}
