package com.baopinghui.bin.mapper.app;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baopinghui.bin.dto.ResultDto;
import com.baopinghui.bin.entity.ActiveEntity;
import com.baopinghui.bin.entity.ArticleEntity;
import com.baopinghui.bin.entity.CourseEntity;
import com.baopinghui.bin.util.MyMapper;

public interface ArticleMapper extends MyMapper<ArticleEntity> {
	
	    //添加作品
	Integer insertArticle(ArticleEntity a);
	    //删除作品
	Integer deleteArticle(@Param(value="id")int id);
	    //更新作品
	Integer updateArticle(ArticleEntity a);
	    //查询所有作品
	List<Map<String,Object>> selectArticle();
	//模糊查询学员关键字查作品
	List<Map<String,Object>> selectArticle2(@Param(value="name")String name);
	//准确查询学员的作品
	List<Map<String,Object>> selectArticle3(@Param(value="name")String name);
	//准确非查询学员的作品
	List<Map<String,Object>> selectArticle4(@Param(value="name")String name);
	Map<String,Object> selectArticle5(@Param(value="id")int id);
	   //更新根据id作品的封面
	Integer updateArticleUrlbyid(@Param(value="id")int id,@Param(value="article_url")String article_url);
	   //更新根据id作品的花絮
	Integer updateHuaxuUrlbyid(@Param(value="id")int id,@Param(value="huaxu_url")String huaxu_url);
	

}
