package com.baopinghui.bin.controller;

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
import com.baopinghui.bin.entity.ActiveEntity;
import com.baopinghui.bin.entity.CourseEntity;
import com.baopinghui.bin.entity.DianMianEntity;
import com.baopinghui.bin.mapper.app.ActiveMapper;
import com.baopinghui.bin.mapper.app.CourseMapper;
import com.baopinghui.bin.mapper.app.DianMianMapper;
import com.baopinghui.bin.service.ActiveService;
import com.baopinghui.bin.service.CourseService;
import com.baopinghui.bin.service.DianMianService;
import com.baopinghui.bin.service.impl.DianmianServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description="活动")
@RequestMapping("wd_Active")
@CrossOrigin
@Controller
public class ActiveController {
	
	
	 @Autowired
	private ActiveService activeService;
	 @Autowired
	 private  ActiveMapper activeMapper;
	
	@ApiOperation(value="添加活动")
	@RequestMapping(value="/insertActive",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto insertActive(
			@ApiParam(value="活动名 required=必填",defaultValue="数学") @RequestParam(required=true)String active_name,
			@ApiParam(value="活动描述",defaultValue="上啥地方好说") @RequestParam(required=false)String active_desc,
			@ApiParam(value="活动地址 required=必填",defaultValue="12222222222")@RequestParam(required=true)String address,
			@ApiParam(value="花絮图片",defaultValue="没什么好说的")@RequestParam(required=false)String huaxu_url,
			@ApiParam(value="活动封面图 ",defaultValue="")@RequestParam(required=false)String active_url,
			@ApiParam(value="活动时间范围 ",defaultValue="")@RequestParam(required=false)String active_date
			){
        ActiveEntity a=new ActiveEntity();
        a.setActive_desc(active_desc);
        a.setActive_name(active_name);
        a.setActive_url(active_url);
        a.setAddress(address);
        a.setHuaxu_url(huaxu_url);
        a.setActive_date(active_date);
//		System.out.println(dianMianEntity);
		Integer b=activeService.insertActive(a);
//		 Integer b=dianMianMapper.insertDianMian(dianMianEntity);
		
		
		 return ResultDto.createSuccess(b);
	}
	
	@ApiOperation(value="更新活动")
	@RequestMapping(value="/updateActive",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto updateActive(
			@ApiParam(value="活动名id required=必填",defaultValue="数学") @RequestParam(required=true)int id,
			@ApiParam(value="活动名 required=必填",defaultValue="数学") @RequestParam(required=true)String active_name,
			@ApiParam(value="活动描述",defaultValue="上啥地方好说") @RequestParam(required=false)String active_desc,
			@ApiParam(value="活动地址 required=必填",defaultValue="12222222222")@RequestParam(required=true)String address,
			@ApiParam(value="花絮图片",defaultValue="没什么好说的")@RequestParam(required=false)String huaxu_url,
			@ApiParam(value="活动封面图 ",defaultValue="")@RequestParam(required=false)String active_url,
			@ApiParam(value="活动时间范围 ",defaultValue="")@RequestParam(required=false)String active_date
			){
        ActiveEntity a=new ActiveEntity();
        a.setId(id);
        a.setActive_desc(active_desc);
        a.setActive_name(active_name);
        a.setActive_url(active_url);
        a.setAddress(address);
        a.setHuaxu_url(huaxu_url);
        a.setActive_date(active_date);
//		System.out.println(dianMianEntity);
		Integer b=activeService.updateActive(a);
//		 Integer b=dianMianMapper.insertDianMian(dianMianEntity);
		
		
		 return ResultDto.createSuccess(b);
	}
	@ApiOperation(value="删除活动")
	@RequestMapping(value="/deleteActive",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto deleteActive(
			@ApiParam(value="活动id  required=必填")@RequestParam(required=true)int id
			){


		Integer b=activeService.deleteActive(id);
		   activeMapper.deleteACbyId(id);

		
		
		 return ResultDto.createSuccess(b);
	}
	@ApiOperation(value="查询所有活动")
	@RequestMapping(value="/selectActive",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto selectActive(
			){


		List<Map<String,Object>> b=activeService.selectActive();

		
		
		 return ResultDto.createSuccess(b);
	}
	@ApiOperation(value="根据id查询活动详情")
	@RequestMapping(value="/selectActive2",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto selectActive2(
			@ApiParam(value="活动id  required=必填")@RequestParam(required=true)int id
			){


		Map<String,Object> b=activeMapper.selectActive2(id);
	     long count=(long)activeMapper.selectActiveCountbyid(id).get("count");
	     b.put("count",count);

		
		
		 return ResultDto.createSuccess(b);
	}
	@ApiOperation(value="更新根据id活动的封面图")
	@RequestMapping(value="/updateActiveUrlbyid",method=RequestMethod.GET)
	@ResponseBody
	public ResultDto updateActiveUrlbyid(
			@ApiParam(value="活动id  required=必填")@RequestParam(required=true)int id,
			@ApiParam(value="活动封面图",defaultValue="12222222222")@RequestParam(required=false)String active_url
			
			){
		Integer b=activeMapper.updateActiveUrlbyid(id, active_url);

		

		
		
		 return ResultDto.createSuccess(b);
	}
	@ApiOperation(value="更新根据id活动的花絮")
	@RequestMapping(value="/updateHuaxuUrlbyid",method=RequestMethod.GET)
	@ResponseBody
	public ResultDto updateHuaxuUrlbyid(
			@ApiParam(value="活动id  required=必填")@RequestParam(required=true)int id,
			@ApiParam(value="活动封面图",defaultValue="12222222222")@RequestParam(required=false)String huaxu_url
			
			){
		Integer b=activeMapper.updateHuaxuUrlbyid(id, huaxu_url);

		

		
		
		 return ResultDto.createSuccess(b);
	}

}
