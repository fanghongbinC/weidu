package com.baopinghui.bin.mapper.app;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baopinghui.bin.dto.ResultDto;
import com.baopinghui.bin.entity.CourseEntity;
import com.baopinghui.bin.util.MyMapper;

public interface CourseMapper extends MyMapper<CourseEntity> {
	
	    //添加课程
	Integer insertCourse(CourseEntity c);
	    //删除课程
	Integer deleteCourse(@Param(value="id")int id);
	    //更新课程
	Integer updateCourse(CourseEntity c);
	    //查询所有课程
	List<Map<String,Object>> selectCourse();
	//根据课程id查询课程详情
	Map<String,Object> selectCourse2(@Param(value="id")int id);
	   //更新根据id课程的封面图
	Integer updateCourseUrlbyid(@Param(value="id")int id,@Param(value="course_url")String course_url);
	   //更新根据id课程的花絮
	Integer updateHuaxuUrlbyid(@Param(value="id")int id,@Param(value="huaxu_url")String huaxu_url);
	//删除学院和课程的链表
	Integer deleteSCbyId(@Param(value="id")int id);
	//根据课程id查询课程的已预定人数
	Map<String,Object> selectCourseCountbyid(@Param(value="id")int id);

}
