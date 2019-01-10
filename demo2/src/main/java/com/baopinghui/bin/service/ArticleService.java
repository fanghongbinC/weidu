package com.baopinghui.bin.service;
import java.util.List;
import java.util.Map;

import com.baopinghui.bin.dto.ResultDto;
import com.baopinghui.bin.entity.ActiveEntity;
import com.baopinghui.bin.entity.ArticleEntity;
import com.baopinghui.bin.entity.DianMianEntity;


public interface ArticleService {
	
	Integer insertArticle(ArticleEntity c);
	
	
	Integer updateArticle(ArticleEntity c);
	
	
	Integer deleteArticle(int id);
	
	
	List<Map<String,Object>>selectArticle();
	
	
	

}
