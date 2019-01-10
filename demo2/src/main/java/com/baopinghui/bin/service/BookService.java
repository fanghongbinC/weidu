package com.baopinghui.bin.service;
import java.util.List;
import java.util.Map;

import com.baopinghui.bin.dto.ResultDto;
import com.baopinghui.bin.entity.ActiveEntity;
import com.baopinghui.bin.entity.BookEntity;
import com.baopinghui.bin.entity.DianMianEntity;


public interface BookService {
	
	Integer insertBook(BookEntity c);
	
	
	Integer updateBook(BookEntity c);
	
	
	Integer deleteBook(int id);
	
	
	List<Map<String,Object>>selectBook();
	
	
	

}
