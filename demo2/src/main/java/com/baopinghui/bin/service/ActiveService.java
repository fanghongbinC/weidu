package com.baopinghui.bin.service;
import java.util.List;
import java.util.Map;

import com.baopinghui.bin.dto.ResultDto;
import com.baopinghui.bin.entity.ActiveEntity;
import com.baopinghui.bin.entity.DianMianEntity;


public interface ActiveService {
	
	Integer insertActive(ActiveEntity c);
	
	
	Integer updateActive(ActiveEntity c);
	
	
	Integer deleteActive(int id);
	
	
	List<Map<String,Object>>selectActive();
	
	
	

}
