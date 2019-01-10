package com.baopinghui.bin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baopinghui.bin.dto.ResultDto;
import com.baopinghui.bin.entity.DianMianEntity;
import com.baopinghui.bin.mapper.app.DianMianMapper;
import com.baopinghui.bin.service.DianMianService;

@Service
@Transactional
public class DianmianServiceImpl implements DianMianService {
	@Autowired
	private DianMianMapper dianMianMapper;

	@Override
	public Integer insertDianmian(DianMianEntity dm) {
		// TODO Auto-generated method stub
		   
		Integer rd=dianMianMapper.insertDianMian(dm);
		return rd;
	}
	@Override
	public Integer updateDianmian(DianMianEntity dm) {
		// TODO Auto-generated method stub
		   
		Integer a=dianMianMapper.updateDianMian(dm);
		return a;
	}
	@Override
	public Integer deleteDianmian(int id) {
		// TODO Auto-generated method stub
		   
		Integer a=dianMianMapper.deleteDianMain(id);
		return a;
	}
	@Override
	public List<Map<String,Object>> selectDianmian() {
		// TODO Auto-generated method stub
		   
		List<Map<String,Object>>a=dianMianMapper.selectDianMian();
		return a;
	}

}
