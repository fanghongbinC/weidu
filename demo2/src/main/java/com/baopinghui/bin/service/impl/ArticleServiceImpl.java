package com.baopinghui.bin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baopinghui.bin.dto.ResultDto;
import com.baopinghui.bin.entity.ActiveEntity;
import com.baopinghui.bin.entity.ArticleEntity;
import com.baopinghui.bin.entity.CourseEntity;
import com.baopinghui.bin.entity.DianMianEntity;
import com.baopinghui.bin.mapper.app.ActiveMapper;
import com.baopinghui.bin.mapper.app.ArticleMapper;
import com.baopinghui.bin.mapper.app.CourseMapper;
import com.baopinghui.bin.service.ActiveService;
import com.baopinghui.bin.service.ArticleService;
import com.baopinghui.bin.service.CourseService;
import com.baopinghui.bin.service.DianMianService;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
	@Autowired
    private ArticleMapper articleMapper;

	@Override
	public Integer insertArticle(ArticleEntity a) {
		// TODO Auto-generated method stub
		Integer rd=articleMapper.insertArticle(a);
		return rd;
	}

	@Override
	public Integer updateArticle(ArticleEntity c) {
		// TODO Auto-generated method stub
		Integer a=articleMapper.updateArticle(c);
		return a;
	}

	@Override
	public Integer deleteArticle(int id) {
		// TODO Auto-generated method stub
		Integer a=articleMapper.deleteArticle(id);
		return a;
	}

	@Override
	public List<Map<String, Object>> selectArticle() {
		// TODO Auto-generated method stub
		 List<Map<String, Object>> a=articleMapper.selectArticle();
		return a;
	}



}
