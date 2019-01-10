package com.baopinghui.bin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baopinghui.bin.dto.ResultDto;
import com.baopinghui.bin.entity.ActiveEntity;
import com.baopinghui.bin.entity.BookEntity;
import com.baopinghui.bin.entity.CourseEntity;
import com.baopinghui.bin.entity.DianMianEntity;
import com.baopinghui.bin.mapper.app.ActiveMapper;
import com.baopinghui.bin.mapper.app.BookMapper;
import com.baopinghui.bin.mapper.app.CourseMapper;
import com.baopinghui.bin.service.ActiveService;
import com.baopinghui.bin.service.BookService;
import com.baopinghui.bin.service.CourseService;
import com.baopinghui.bin.service.DianMianService;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	@Autowired
    private BookMapper bookMapper;

	@Override
	public Integer insertBook(BookEntity c) {
		// TODO Auto-generated method stub
		Integer b=bookMapper.insertBook(c);
		return b;
	}

	@Override
	public Integer updateBook(BookEntity c) {
		// TODO Auto-generated method stub
		Integer b=bookMapper.updateBook(c);
		return b;
	}

	@Override
	public Integer deleteBook(int id) {
		// TODO Auto-generated method stub
		Integer b=bookMapper.deleteBook(id);
		return b;
	}

	@Override
	public List<Map<String, Object>> selectBook() {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list=bookMapper.selectBook();
		return list;
	}

	


}
