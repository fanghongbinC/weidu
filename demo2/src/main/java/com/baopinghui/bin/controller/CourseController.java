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
import com.baopinghui.bin.entity.CourseEntity;
import com.baopinghui.bin.entity.DianMianEntity;
import com.baopinghui.bin.mapper.app.CourseMapper;
import com.baopinghui.bin.mapper.app.DianMianMapper;
import com.baopinghui.bin.service.CourseService;
import com.baopinghui.bin.service.DianMianService;
import com.baopinghui.bin.service.impl.DianmianServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description="课程")
@RequestMapping("wd_Course")
@CrossOrigin
@Controller
public class CourseController {
	
	
	 @Autowired
	private CourseService courseService;
	 @Autowired
	 private CourseMapper courseMapper;

	
	@ApiOperation(value="添加课程")
	@RequestMapping(value="/insertCourse",method=RequestMethod.GET)
	@ResponseBody
	public ResultDto insertCourse(
			@ApiParam(value="课程名 required=必填",defaultValue="数学") @RequestParam(required=true)String course_name,
			@ApiParam(value="课程描述",defaultValue="上啥地方好说") @RequestParam(required=false)String course_desc,
			@ApiParam(value="课程封面图",defaultValue="12222222222")@RequestParam(required=false)String course_url,
			@ApiParam(value="花絮图片",defaultValue="没什么好说的")@RequestParam(required=false)String huaxu_url,
			@ApiParam(value="课程店面id required=必填",defaultValue="")@RequestParam(required=true)int dianmian_id,
			@ApiParam(value="课程时间范围",defaultValue="")@RequestParam(required=false)String course_date,
			@ApiParam(value="课程年龄范围",defaultValue="")@RequestParam(required=false)String year
			){
      CourseEntity c=new CourseEntity();
      c.setCourse_desc(course_desc);
      c.setCourse_name(course_name);
      c.setHuaxu_url(huaxu_url);
      c.setCourse_url(course_url);
      c.setDianmian_id(dianmian_id);
      c.setCourse_date(course_date);
      c.setYear(year);
//		System.out.println(dianMianEntity);
		Integer b=courseService.insertCourse(c);
//		 Integer b=dianMianMapper.insertDianMian(dianMianEntity);
		
		
		 return ResultDto.createSuccess(b);
	}
	@ApiOperation(value="更新课程")
	@RequestMapping(value="/updateCourse",method=RequestMethod.GET)
	@ResponseBody
	public ResultDto uodateCourse(
			@ApiParam(value="课程id required=必填",defaultValue="")@RequestParam(required=true)int id,
			@ApiParam(value="课程名 required=必填",defaultValue="数学") @RequestParam(required=true)String course_name,
			@ApiParam(value="课程描述",defaultValue="上啥地方好说") @RequestParam(required=false)String course_desc,
			@ApiParam(value="课程封面图",defaultValue="12222222222")@RequestParam(required=false)String course_url,
			@ApiParam(value="花絮图片",defaultValue="没什么好说的")@RequestParam(required=false)String huaxu_url,
			@ApiParam(value="课程店面id required=必填",defaultValue="")@RequestParam(required=true)int dianmian_id,
			@ApiParam(value="课程时间范围",defaultValue="")@RequestParam(required=false)String course_date,
			@ApiParam(value="课程年龄范围",defaultValue="")@RequestParam(required=false)String year
			){
      CourseEntity c=new CourseEntity();
      c.setId(id);
      c.setCourse_desc(course_desc);
      c.setCourse_name(course_name);
      c.setHuaxu_url(huaxu_url);
      c.setCourse_url(course_url);
      c.setCourse_date(course_date);
      c.setDianmian_id(dianmian_id);
      c.setYear(year);

		Integer b=courseService.updateCourse(c);

		
		
		 return ResultDto.createSuccess(b);
	}
	@ApiOperation(value="删除课程")
	@RequestMapping(value="/deleteCourse",method=RequestMethod.GET)
	@ResponseBody
	public ResultDto deleteDianMian(
			@ApiParam(value="课程id  required=必填")@RequestParam(required=true)int id
			){


		Integer b=courseService.deleteCourse(id);
		      courseMapper.deleteSCbyId(id);

		
		
		 return ResultDto.createSuccess(b);
	}
	@ApiOperation(value="更新根据id课程的封面图")
	@RequestMapping(value="/updateCourseUrlbyid",method=RequestMethod.GET)
	@ResponseBody
	public ResultDto updateCourseUrlbyid(
			@ApiParam(value="课程id  required=必填")@RequestParam(required=true)int id,
			@ApiParam(value="课程封面图",defaultValue="12222222222")@RequestParam(required=false)String course_url
			
			){
		Integer b=courseMapper.updateCourseUrlbyid(id, course_url);

		

		
		
		 return ResultDto.createSuccess(b);
	}
	@ApiOperation(value="更新根据id课程的花絮")
	@RequestMapping(value="/updateHuaxuUrlbyid",method=RequestMethod.GET)
	@ResponseBody
	public ResultDto updateHuaxuUrlbyid(
			@ApiParam(value="课程id  required=必填")@RequestParam(required=true)int id,
			@ApiParam(value="课程封面图",defaultValue="12222222222")@RequestParam(required=false)String huaxu_url
			
			){
		Integer b=courseMapper.updateHuaxuUrlbyid(id, huaxu_url);

		

		
		
		 return ResultDto.createSuccess(b);
	}
	@ApiOperation(value="查询所有课程")
	@RequestMapping(value="/selectCourse",method=RequestMethod.GET)
	@ResponseBody
	public ResultDto selectDianMian(
			){


		List<Map<String,Object>> b=courseService.selectCourse();

		
		
		 return ResultDto.createSuccess(b);
	}
	@ApiOperation(value="根据课程id查询课程详情")
	@RequestMapping(value="/selectCourse2",method=RequestMethod.GET)
	@ResponseBody
	public ResultDto selectDianMian2(
			@ApiParam(value="课程id  required=必填")@RequestParam(required=true)int id
			){


		Map<String,Object> b=courseMapper.selectCourse2(id);
		     long count=(long)courseMapper.selectCourseCountbyid(id).get("count");
		     b.put("count",count);

		
		
		 return ResultDto.createSuccess(b);
	}

}
