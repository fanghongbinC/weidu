package com.baopinghui.bin.service;
import java.util.List;
import java.util.Map;

import com.baopinghui.bin.dto.ResultDto;
import com.baopinghui.bin.entity.ActiveEntity;
import com.baopinghui.bin.entity.DianMianEntity;
import com.baopinghui.bin.entity.StudentEntity;


public interface StudentService {
	
	Integer insertStudent(StudentEntity c);
	
	
	Integer updateStudent(StudentEntity c);
	
	
	Integer deleteStudent(int id);
	
	
	List<Map<String,Object>>selectStudent();
	
	
	

}
