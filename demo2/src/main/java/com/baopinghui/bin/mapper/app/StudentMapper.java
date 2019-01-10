package com.baopinghui.bin.mapper.app;

import java.util.List;
import java.util.Map;
import com.baopinghui.bin.entity.StudentEntity;
import com.baopinghui.bin.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import com.baopinghui.bin.dto.ResultDto;


public interface StudentMapper extends MyMapper<StudentEntity> {
	
	    //添加学员
	Integer insertStudent(StudentEntity s);
	    //删除学员信息
	Integer deleteStudent(@Param(value="id")int id);
	    //更新学员信息
	Integer updateStudent(StudentEntity s);
	    //查询所有学员信息
	List<Map<String,Object>> selectStudent();
	//关键字
	List<Map<String,Object>> selectStudent2(@Param(value="name")String name);
	    //查询所有学员信息完全版课程
	List<Map<String,Object>> selectStudentAll1(@Param(value="id")long id);
	   //查询所有学员信息完全版活动
		List<Map<String,Object>> selectStudentAll2(@Param(value="id")long id);
	Integer	deleteCSbyid(@Param(value="id")int id);
	
	Integer	deleteASbyid(@Param(value="id")int id);
	
	Integer	insertCSbyid(@Param(value="student_id")int student_id,@Param(value="course_id")int course_id);
	
	Integer	insertASbyid(@Param(value="student_id")int student_id,@Param(value="active_id")int active_id);
	
	Map<String,Object> selectlastId();
	
	Map<String,Object> selectStudentbyname(@Param(value="name")String name);
}
