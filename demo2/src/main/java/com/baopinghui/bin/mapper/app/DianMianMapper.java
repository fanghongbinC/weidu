package com.baopinghui.bin.mapper.app;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baopinghui.bin.dto.ResultDto;
import com.baopinghui.bin.entity.DianMianEntity;
import com.baopinghui.bin.util.MyMapper;

public interface DianMianMapper extends MyMapper<DianMianEntity>  {
	//新增店铺
	Integer insertDianMian(DianMianEntity dm);
	//更新店的消息
	Integer updateDianMian(DianMianEntity dm);
	//删除店铺
	Integer deleteDianMain(@Param(value="id")int id);
	//查询所有店面
	List<Map<String,Object>> selectDianMian();
	//id查询
	Map<String,Object> selectDianMian2(@Param(value="id")int id);
	
}
