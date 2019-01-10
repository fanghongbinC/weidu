package com.baopinghui.bin.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baopinghui.bin.dto.ResultDto;
import com.baopinghui.bin.entity.BookEntity;
import com.baopinghui.bin.entity.DianMianEntity;
import com.baopinghui.bin.mapper.app.BookMapper;
import com.baopinghui.bin.mapper.app.DianMianMapper;
import com.baopinghui.bin.service.BookService;
import com.baopinghui.bin.service.DianMianService;
import com.baopinghui.bin.service.impl.DianmianServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description="学员预定")
@RequestMapping("wd_book")
@CrossOrigin
@Controller
public class BookController {
	
	
	 @Autowired
	private BookService bookService;
    @Autowired
	private BookMapper bookMapper;
	
	@ApiOperation(value="添加学员的预定")
	@RequestMapping(value="/insertBook",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto insertBook(
			@ApiParam(value="预约的学员名字 required=必填",defaultValue="李白") @RequestParam(required=true)String username,
			@ApiParam(value="选的课程",defaultValue="数学") @RequestParam(required=false)String course,
			@ApiParam(value="选择的店面required=必填",defaultValue="白云机场") @RequestParam(required=true)String dianmian,
			@ApiParam(value="选的活动",defaultValue="地狱一日游")@RequestParam(required=false)String active,
			@ApiParam(value="联系电话 required=必填",defaultValue="10086")@RequestParam(required=true)String phone,
			@ApiParam(value="操作的状态 0未联系1已联系",defaultValue="这里默认0")@RequestParam(required=false)int statu
			){
	 BookEntity b=new BookEntity();
     Date create_date1=new Date();
     java.sql.Date create_date=new java.sql.Date(create_date1.getTime());
           b.setActive(active);
           b.setCourse(course);
           b.setdCreate_date(create_date);
           b.setDianmian(dianmian);
           b.setPhone(phone);
           b.setUsername(username);
           b.setStatu(statu);
        Integer i=bookService.insertBook(b);
		 return ResultDto.createSuccess(i);
	}
	@ApiOperation(value="更新学员的预定")
	@RequestMapping(value="/updateBook",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto updateBook(
			 @ApiParam(value="更新预定id required=必填 ",defaultValue="2")@RequestParam(required=true)int id,
			@ApiParam(value="预约的学员名字 required=必填",defaultValue="李白") @RequestParam(required=true)String username,
			@ApiParam(value="选的课程",defaultValue="数学") @RequestParam(required=false)String course,
			@ApiParam(value="选择的店面required=必填",defaultValue="白云机场") @RequestParam(required=true)String dianmian,
			@ApiParam(value="选的活动",defaultValue="地狱一日游")@RequestParam(required=false)String active,
			@ApiParam(value="联系电话 required=必填",defaultValue="10086")@RequestParam(required=true)String phone,
			@ApiParam(value="操作的状态 0未联系1已联系",defaultValue="这里默认0")@RequestParam(required=false)int statu
			){
	 BookEntity b=new BookEntity();
     Date create_date1=new Date();
     java.sql.Date create_date=new java.sql.Date(create_date1.getTime());
//     java.sql.Date date=new java.sql.Date();
//     java.util.Date d=new java.util.Date (date.getTime());
            b.setId(id);
           b.setActive(active);
           b.setCourse(course);
           b.setdCreate_date(create_date);
           b.setDianmian(dianmian);
           b.setPhone(phone);
           b.setUsername(username);
           b.setStatu(statu);
          Integer i=bookService.updateBook(b);
		 return ResultDto.createSuccess(i);
	}
	@ApiOperation(value="删除预定名单")
	@RequestMapping(value="/deleteBook",method=RequestMethod.GET)
	@ResponseBody
	public ResultDto deleteBook(
			@ApiParam(value="预定名单id  required=必填")@RequestParam(required=true)int id
			){


		Integer b=bookService.deleteBook(id);

		
		
		 return ResultDto.createSuccess(b);
	}
	@ApiOperation(value="查询所有预定名单")
	@RequestMapping(value="/selectBook",method=RequestMethod.GET)
	@ResponseBody
	public ResultDto selectBook(
			){


		List<Map<String,Object>> b=bookService.selectBook();
//		List<Map<String,Object>> b=bookMapper.selectBook1("'4','5'");
		
		
		 return ResultDto.createSuccess(b);
	}
	@ApiOperation(value="更新预定的状态")
	@RequestMapping(value="/updateBookstatu",method=RequestMethod.GET)
	@ResponseBody
	public ResultDto updateBookstatu(
			@ApiParam(value="预定的id required=必填")@RequestParam(required=true) int id
			){


		int b=bookMapper.updatestatu(id);

		
		
		 return ResultDto.createSuccess(b);
	}

}
