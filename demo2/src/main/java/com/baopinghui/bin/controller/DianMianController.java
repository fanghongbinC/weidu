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
import com.baopinghui.bin.entity.DianMianEntity;
import com.baopinghui.bin.mapper.app.DianMianMapper;
import com.baopinghui.bin.service.DianMianService;
import com.baopinghui.bin.service.impl.DianmianServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description="店面")
@RequestMapping("wd_dianMian")
@CrossOrigin
@Controller
public class DianMianController {
	
	
	 @Autowired
	private DianMianService dianMianService;
    @Autowired
	private DianMianMapper dianMianMapper;
	
	@ApiOperation(value="添加店面")
	@RequestMapping(value="/insertDianMian",method=RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public ResultDto insertDianMian(
			@ApiParam(value="店名称 required=必填",defaultValue="上天吧") @RequestParam(required=true)String dmname,
			@ApiParam(value="地址",defaultValue="上天吧") @RequestParam(required=false)String address,
			@ApiParam(value="电话",defaultValue="12222222222")@RequestParam(required=false)String phone,
			@ApiParam(value="备注",defaultValue="没什么好说的")@RequestParam(required=false)String desc
			){
	 DianMianEntity dianMianEntity = new DianMianEntity();
		dianMianEntity.setAddress(address);
		dianMianEntity.setDmdesc(desc);
		dianMianEntity.setPhone(phone);
		dianMianEntity.setDmname(dmname);
//		System.out.println(dianMianEntity);
		Integer b=dianMianService.insertDianmian(dianMianEntity);
//		 Integer b=dianMianMapper.insertDianMian(dianMianEntity);
		
		
		 return ResultDto.createSuccess(b);
	}
	@CrossOrigin
	@ApiOperation(value="更新店面消息")
	@RequestMapping(value="/updateDianMian",method=RequestMethod.GET)
	@ResponseBody
	public ResultDto updateDianMian(
			@ApiParam(value="店id  required=必填")@RequestParam(required=true)int id,
			@ApiParam(value="店名称 required=必填",defaultValue="上天吧") @RequestParam(required=true)String dmname,
			@ApiParam(value="地址",defaultValue="上天吧") @RequestParam(required=false)String address,
			@ApiParam(value="电话",defaultValue="12222222222")@RequestParam(required=false)String phone,
			@ApiParam(value="备注",defaultValue="没什么好说的")@RequestParam(required=false)String desc
			){
	 DianMianEntity dianMianEntity = new DianMianEntity();
	    dianMianEntity.setId(id);
		dianMianEntity.setAddress(address);
		dianMianEntity.setDmdesc(desc);
		dianMianEntity.setPhone(phone);
		dianMianEntity.setDmname(dmname);
//		System.out.println(dianMianEntity);
		Integer b=dianMianService.updateDianmian(dianMianEntity);
//		 Integer b=dianMianMapper.insertDianMian(dianMianEntity);
		
		
		 return ResultDto.createSuccess(b);
	}
	@CrossOrigin
	@ApiOperation(value="删除店铺")
	@RequestMapping(value="/deleteDianMian",method=RequestMethod.GET)
	@ResponseBody
	public ResultDto deleteDianMian(
			@ApiParam(value="店id  required=必填")@RequestParam(required=true)int id
			){


		Integer b=dianMianService.deleteDianmian(id);

		
		
		 return ResultDto.createSuccess(b);
	}
	@CrossOrigin
	@ApiOperation(value="查询所有店铺")
	@RequestMapping(value="/selectDianMian",method=RequestMethod.GET)
	@ResponseBody
	public ResultDto selectDianMian(
			){


		List<Map<String,Object>> b=dianMianService.selectDianmian();

		
		
		 return ResultDto.createSuccess(b);
	}
	@CrossOrigin
	@ApiOperation(value="根据店面id查询店面详情")
	@RequestMapping(value="/selectDianMian2",method=RequestMethod.GET)
	@ResponseBody
	public ResultDto selectDianMian2(
			@RequestParam(required=true) @ApiParam(value="店面id")int id
			){


	Map<String,Object> b=dianMianMapper.selectDianMian2(id);

		
		
		 return ResultDto.createSuccess(b);
	}

}
