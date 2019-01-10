package com.baopinghui.bin.mapper.app;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baopinghui.bin.dto.ResultDto;
import com.baopinghui.bin.entity.BookEntity;
import com.baopinghui.bin.entity.CourseEntity;
import com.baopinghui.bin.util.MyMapper;

public interface BookMapper extends MyMapper<BookEntity> {
	
	    //添加预约
	Integer insertBook(BookEntity b);
	    //删除预约
	Integer deleteBook(@Param(value="id")int id);
	    //更新预约
	Integer updateBook(BookEntity b);
	    //查询预约
	List<Map<String,Object>> selectBook();
	    //更新预约的状态
	Integer updatestatu(@Param(value="id")int id);
	
	List<Map<String,Object>> selectBook1(@Param(value="id")String id);
	

}
