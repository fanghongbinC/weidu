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
import com.baopinghui.bin.entity.StudentEntity;
import com.baopinghui.bin.mapper.app.StudentMapper;
import com.baopinghui.bin.service.StudentService;
import com.google.common.base.Strings;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description="学员")
@RequestMapping("wd_Student")
@CrossOrigin
@Controller
		public class StudentController {
	   @Autowired
	   private  StudentService studentService;
	   @Autowired
	   private  StudentMapper studentMapper;
	   
	   @ApiOperation(value="添加学员信息")
	   @RequestMapping(value="/insertStudent",method=RequestMethod.POST)
	   @ResponseBody
	   public ResultDto insertStudent(
			   @ApiParam(value="学员名字 required=必填",defaultValue="王小明")@RequestParam(required=true)String student_name,
			   @ApiParam(value="学员的联系方式",defaultValue="121231232131")@RequestParam(required=false)String phone,
			   @ApiParam(value="学员的备注",defaultValue="什么鬼学员啊")@RequestParam(required=false)String s_desc,
			   @ApiParam(value="选的课程id集合",defaultValue="1,3,3")@RequestParam(required=false)String  cid,
			   @ApiParam(value="选的课程id集合",defaultValue="4,3")@RequestParam(required=false)String  aid
			   ){
		   StudentEntity s=new StudentEntity();
		   s.setPhone(phone);
		   s.setS_desc(s_desc);
		   s.setStudent_name(student_name);
		  Integer b= studentService.insertStudent(s);
		  Map<String,Object> map=studentMapper.selectlastId();
		         long idy =(long)map.get("id");
		         int  id=(int)idy;
		         
			  if(cid!=""&&cid!=null){
//				  studentMapper.deleteCSbyid(id);
				  String [] a=cid.split(",");
				  for(int i=0;i<a.length;i++){
					  int bin=Integer.parseInt(a[i]);
					  studentMapper.insertCSbyid(id, bin);
					 
				  }
				  				  
			  }
			  if(aid!=""&&aid!=null){
//				  studentMapper.deleteASbyid(id);
				  System.out.println("ssss");
				  String [] a=aid.split(",");
				  System.out.println(a);
				  for(int i=0;i<a.length;i++){
					  int bin=Integer.parseInt(a[i]);
					  studentMapper.insertASbyid(id, bin);
					 
				  }
				  				  
			  }
	
		   
		   
		   return ResultDto.createSuccess(id);
		   
	   }
	   @ApiOperation(value="更新学员信息")
	   @RequestMapping(value="/updateStudent",method=RequestMethod.POST)
	   @ResponseBody
	   public ResultDto updateStudent(
			   @ApiParam(value="学员id required=必填",defaultValue="")@RequestParam(required=true)int id,
			   @ApiParam(value="学员名字 required=必填",defaultValue="王小明")@RequestParam(required=true)String student_name,
			   @ApiParam(value="学员的联系方式",defaultValue="121231232131")@RequestParam(required=false)String phone,
			   @ApiParam(value="学员的备注",defaultValue="什么鬼学员啊")@RequestParam(required=false)String s_desc
			   ){
		   StudentEntity s=new StudentEntity();
		   s.setId(id);
		   s.setPhone(phone);
		   s.setS_desc(s_desc);
		   s.setStudent_name(student_name);
		  Integer a= studentService.updateStudent(s);
		   
		   
		   return ResultDto.createSuccess(a);
		   
	   }
	   @ApiOperation(value="删除学员信息")
		@RequestMapping(value="/deleteStudent",method=RequestMethod.POST)
		@ResponseBody
		public ResultDto deleteStudent(
				@ApiParam(value="活动id  required=必填")@RequestParam(required=true)int id
				){


			Integer b=studentService.deleteStudent(id);
			 studentMapper.deleteCSbyid(id);
			 studentMapper.deleteASbyid(id);
			
			
			 return ResultDto.createSuccess(b);
		}
		@ApiOperation(value="查询所有学员信息")
		@RequestMapping(value="/selectStudent",method=RequestMethod.POST)
		@ResponseBody
		public List<Map<String,Object>> selectActive(
				){


			List<Map<String,Object>> b=studentService.selectStudent();

			
			
			 return b;
		}
		@ApiOperation(value="查询所有学员信息完全版信息版")
		@RequestMapping(value="/selectStudentAll",method=RequestMethod.GET)
		@ResponseBody
		public ResultDto selectActiveAll(
				){
			List<Map<String,Object>> b=studentService.selectStudent();
			   for(Map m:b){
				  long id=(long)m.get("id");
				  List<Map<String,Object>> st1=studentMapper.selectStudentAll1(id);
				  m.put("coursename", st1);
				  List<Map<String,Object>> st2=studentMapper.selectStudentAll2(id);
				  m.put("activename", st2);
				  
				       
				   
				   
			   }
			 return ResultDto.createSuccess(b);
		}
		@ApiOperation(value="判断该学员存不存在")
		@RequestMapping(value="/selectStudentbyname",method=RequestMethod.GET)
		@ResponseBody
		public ResultDto selectStudentbyname(
				@ApiParam(value="输入名字")@RequestParam(required=true)String name
				){
			     if(Strings.isNullOrEmpty(name)){
			    	 return ResultDto.createError1();
			     }
			     long count=(long)studentMapper.selectStudentbyname(name).get("count");
			     if(count>0){
			    	 return ResultDto.createSuccess(true);
			     }else{
			    	 return ResultDto.createSuccess(false);
			     }
		
			
		}
		@ApiOperation(value="查询所有学员信息完全版信息版根据关键字")
		@RequestMapping(value="/selectStudentAll2",method=RequestMethod.GET)
		@ResponseBody
		public ResultDto selectActiveAll2(
				 @ApiParam(value="输入学员名关键字",defaultValue="")@RequestParam(required=false)String name
				){
			List<Map<String,Object>> b=studentMapper.selectStudent2(name);
			   for(Map m:b){
				  long id=(long)m.get("id");
				  List<Map<String,Object>> st1=studentMapper.selectStudentAll1(id);
				  m.put("coursename", st1);
				  List<Map<String,Object>> st2=studentMapper.selectStudentAll2(id);
				  m.put("activename", st2);
				  
				       
				   
				   
			   }
			 return ResultDto.createSuccess(b);
		}
		   @ApiOperation(value="更新学员完全版信息")
		   @RequestMapping(value="/updateStudent",method=RequestMethod.GET)
		   @ResponseBody
		   public ResultDto updateStudentALL(
				   @ApiParam(value="学员id required=必填",defaultValue="")@RequestParam(required=true)int id,
				   @ApiParam(value="学员名字 required=必填",defaultValue="王小明")@RequestParam(required=true)String student_name,
				   @ApiParam(value="学员的联系方式",defaultValue="121231232131")@RequestParam(required=false)String phone,
				   @ApiParam(value="学员的备注",defaultValue="什么鬼学员啊")@RequestParam(required=false)String s_desc,
				   @ApiParam(value="选的课程id集合",defaultValue="1,3,3")@RequestParam(required=false)String  cid,
				   @ApiParam(value="选的课程id集合",defaultValue="4,3")@RequestParam(required=false)String  aid
				   ){
//			   StudentEntity s=new StudentEntity();
//			   s.setId(id);
//			   s.setPhone(phone);
//			   s.setS_desc(s_desc);
//			   s.setStudent_name(student_name);
//			  Integer a= studentService.updateStudent(s);
			 
			  if(cid!=""&&cid!=null){
				  studentMapper.deleteCSbyid(id);
				  String [] a=cid.split(",");
				  for(int i=0;i<a.length;i++){
					  int bin=Integer.parseInt(a[i]);
					  studentMapper.insertCSbyid(id, bin);
					 
				  }
				  				  
			  }
			  if(aid!=""&&aid!=null){
				  studentMapper.deleteASbyid(id);
				  System.out.println("ssss");
				  String [] a=aid.split(",");
				  System.out.println(a);
				  for(int i=0;i<a.length;i++){
					  int bin=Integer.parseInt(a[i]);
					  studentMapper.insertASbyid(id, bin);
					 
				  }
				  				  
			  }
			   StudentEntity s=new StudentEntity();
			   s.setId(id);
			   s.setPhone(phone);
			   s.setS_desc(s_desc);
			   s.setStudent_name(student_name);
			  Integer a= studentService.updateStudent(s);
			  
		
			   
			   
			   return ResultDto.createSuccess(a);
			   
		   }
		
	   

}
