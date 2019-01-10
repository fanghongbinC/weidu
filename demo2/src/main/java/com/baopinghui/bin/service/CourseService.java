package com.baopinghui.bin.service;
import java.util.List;
import java.util.Map;

import com.baopinghui.bin.dto.ResultDto;
import com.baopinghui.bin.entity.CourseEntity;
import com.baopinghui.bin.entity.DianMianEntity;


public interface CourseService {
	
	Integer insertCourse(CourseEntity c);
	
	
	Integer updateCourse(CourseEntity c);
	
	
	Integer deleteCourse(int id);
	
	
	List<Map<String,Object>>selectCourse();
	
	
	

}
