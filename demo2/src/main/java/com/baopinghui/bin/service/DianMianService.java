package com.baopinghui.bin.service;
import java.util.List;
import java.util.Map;

import com.baopinghui.bin.dto.ResultDto;
import com.baopinghui.bin.entity.DianMianEntity;


public interface DianMianService {
	
	Integer insertDianmian(DianMianEntity dm);
	
	
	Integer updateDianmian(DianMianEntity dm);
	
	
	Integer deleteDianmian(int id);
	
	
	List<Map<String,Object>>selectDianmian();
	
	
	

}
