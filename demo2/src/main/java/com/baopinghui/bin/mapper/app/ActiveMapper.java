package com.baopinghui.bin.mapper.app;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baopinghui.bin.dto.ResultDto;
import com.baopinghui.bin.entity.ActiveEntity;
import com.baopinghui.bin.entity.CourseEntity;
import com.baopinghui.bin.util.MyMapper;

public interface ActiveMapper extends MyMapper<ActiveEntity> {
	
	    //添加活动
	Integer insertActive(ActiveEntity a);
	    //删除活动
	Integer deleteActive(@Param(value="id")int id);
	    //更新活动
	Integer updateActive(ActiveEntity a);
	    //查询所有活动
	List<Map<String,Object>> selectActive();
	//根据id 查询活动详情
	Map<String,Object> selectActive2(@Param(value="id")int id);
	Integer updateActiveUrlbyid(@Param(value="id")int id,@Param(value="active_url")String active_url);
	   //更新根据id课程的花絮
	Integer updateHuaxuUrlbyid(@Param(value="id")int id,@Param(value="huaxu_url")String huaxu_url);
	//删除活动和学生的链表
	Integer deleteACbyId(@Param(value="id")int id);
	//根据课程id查询课程的已预定人数
	Map<String,Object> selectActiveCountbyid(@Param(value="id")int id);
	

}
