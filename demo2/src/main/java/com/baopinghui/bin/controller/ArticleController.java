package com.baopinghui.bin.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baopinghui.bin.dto.ResultDto;
import com.baopinghui.bin.entity.ArticleEntity;
import com.baopinghui.bin.entity.StudentEntity;
import com.baopinghui.bin.mapper.app.ArticleMapper;
import com.baopinghui.bin.qiniu.qiniuUtil;
import com.baopinghui.bin.service.ArticleService;
import com.baopinghui.bin.service.StudentService;
import com.google.common.base.Strings;
import com.qiniu.common.QiniuException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description="学员作品")
@RequestMapping("wd_Article")
@CrossOrigin
@Controller
		public class ArticleController {
	   @Autowired
	   private  ArticleService articleService;
	   @Autowired
	   private ArticleMapper articleMapper;
	   
	   
	   @ApiOperation(value="添加学员作品")
	   @RequestMapping(value="/insertArticle",method=RequestMethod.POST)
	   @ResponseBody
	   @CrossOrigin
	   public ResultDto insertArticle(
			   @ApiParam(value="作品图片 ",defaultValue="11451651.jpg")@RequestParam(required=false)String article_url,
			   @ApiParam(value="作品描述",defaultValue="121231232131")@RequestParam(required=false)String article_desc,
			   @ApiParam(value="学员的备注",defaultValue="2")@RequestParam(required=true)int student_id,
			   @ApiParam(value="花絮图片",defaultValue="11451651.jpg")@RequestParam(required=false)String huaxu_url,
			   @ApiParam(value="显示时间",defaultValue="")@RequestParam(required=false)String create_date_c
			   ){
		ArticleEntity a=new ArticleEntity();
		Date create_date=new Date();
		a.setCreate_date_c(create_date_c);
		a.setArticle_desc(article_desc);
		a.setArticle_url(article_url);
		a.setHuaxu_url(huaxu_url);
		a.setCreate_date(create_date);
		a.setStudent_id(student_id);
		
		
		  Integer b= articleService.insertArticle(a);
		   
		   
		   return ResultDto.createSuccess(b);
		   
	   }
	   @CrossOrigin
	   @ApiOperation(value="更新学员作品")
	   @RequestMapping(value="/updateArticle",method=RequestMethod.POST)
	   @ResponseBody
	   public ResultDto updateArticle(
			   @ApiParam(value="学员作品id",defaultValue="2")@RequestParam(required=true)int id,
			   @ApiParam(value="作品图片 ",defaultValue="11451651.jpg")@RequestParam(required=false)String article_url,
			   @ApiParam(value="作品描述",defaultValue="121231232131")@RequestParam(required=false)String article_desc,
			   @ApiParam(value="学员的备注id",defaultValue="1")@RequestParam(required=true)int student_id,
			   @ApiParam(value="花絮图片",defaultValue="11451651.jpg")@RequestParam(required=false)String huaxu_url,
			   @ApiParam(value="显示时间",defaultValue="")@RequestParam(required=false)String create_date_c
			   ){
		ArticleEntity a=new ArticleEntity();
		a.setId(id);
//		Date create_date=new Date();
		a.setCreate_date_c(create_date_c);
		a.setArticle_desc(article_desc);
		a.setArticle_url(article_url);
		a.setHuaxu_url(huaxu_url);
		a.setStudent_id(student_id);
//		a.setCreate_date(create_date);
		
		
		  Integer b= articleService.updateArticle(a);
		   
		   
		   return ResultDto.createSuccess(b);
		   
	   }
	   @CrossOrigin
	   @ApiOperation(value="删除学员作品")
		@RequestMapping(value="/deleteArticle",method=RequestMethod.POST)
		@ResponseBody
		public ResultDto deleteArticle(
				@ApiParam(value="活动id  required=必填")@RequestParam(required=true)int id
				){


			Integer b=articleService.deleteArticle(id);

			
			
			 return ResultDto.createSuccess(b);
		}
		@ApiOperation(value="查询所有作品信息")
		@RequestMapping(value="/selectArticle",method=RequestMethod.POST)
		@ResponseBody
		public ResultDto selectArticle(
				){


			List<Map<String,Object>> b=articleService.selectArticle();

			
			
			 return ResultDto.createSuccess(b);
		}
		@ApiOperation(value="查询所有作品信息更加学员的关键字")
		@RequestMapping(value="/selectArticle2",method=RequestMethod.POST)
		@ResponseBody
		public ResultDto selectArticle2(
				@ApiParam(value="学员名的关键字")@RequestParam(required=false)String name
				){


			List<Map<String,Object>> b=articleMapper.selectArticle2(name);

			
			
			 return ResultDto.createSuccess(b);
		}
		@ApiOperation(value="根据准确的学员名查询其作品")
		@RequestMapping(value="/selectArticle3",method=RequestMethod.POST)
		@ResponseBody
		public ResultDto selectArticle3(
				@ApiParam(value="输入学员名")@RequestParam(required=false)String name
				){


			List<Map<String,Object>> b=articleMapper.selectArticle3(name);

			
			
			 return ResultDto.createSuccess(b);
		}
		@ApiOperation(value="查询不是该成员的其他作品")
		@RequestMapping(value="/selectArticle4",method=RequestMethod.POST)
		@ResponseBody
		public ResultDto selectArticle4(
				@ApiParam(value="输入学员名")@RequestParam(required=false)String name
				){


			List<Map<String,Object>> b=articleMapper.selectArticle4(name);

			
			
			 return ResultDto.createSuccess(b);
		}
		@ApiOperation(value="根据作品id查作品详情")
		@RequestMapping(value="/selectArticle5",method=RequestMethod.POST)
		@ResponseBody
		public ResultDto selectArticle5(
				@ApiParam(value="活动id  required=必填")@RequestParam(required=true)int id
				){


			Map<String,Object> b=articleMapper.selectArticle5(id);

			
			
			 return ResultDto.createSuccess(b);
		}
		//接受前端POST传递过来的图片,图片的格式是FormData格式，可通过form表单发送。文件的name与参数名必须一样
				//上传的思路是先把图片上传到自己的服务器，然后再通过服务器再上传到七牛云
				@CrossOrigin
				@ApiOperation(value="上传图片")
				@RequestMapping(value="/Qiniu_upload/formdata",method=RequestMethod.POST)
				@ResponseBody
			    public ResultDto gexingSet1(
			    		@ApiParam(value = "上传的图片") @RequestParam(value = "file", required = true)MultipartFile file,
			    		@ApiParam(value = "网络访问的名字,要唯一,不然会失败")@RequestParam(required=false)String name,
			    		@ApiParam(value = "如果该文件名是否覆盖,默认不覆盖,重复则失败")@RequestParam(required=false)boolean force ,
			             HttpServletRequest request,HttpServletResponse response) {  //name和addrinfo是表单提交的数据 因为文件上传有可能带有其他参数   但是名字要与表单里的名字一样
//			        String fileName = file.getOriginalFilename(); //获取文件名
					//处理跨域的响应
					response.setHeader("Access-Control-Allow-Origin", "*");
//					 String key=""; 
					String fileName="";
					int   status=0; //0代表失败 ，1代表成功
			        if (!file.isEmpty()) {
			        	
			        	   
//			            String path=request.getSession().getServletContext().getRealPath("/");
//			        	String path = "/home/imgs";   //+ File.separator;
			        	String path="D:/TomCat/upload";
			    		// 创建文件夹
			    		File folder = new File(path);
			    		String uploadPath="";
			    		if (!folder.exists()) {
			    	
			    			boolean b = folder.mkdirs();
//			    			logger.info("创建文件夹结果:" + b);
			    		}
			    	
			    			  fileName =Strings.isNullOrEmpty(name)?(UUID.randomUUID() + ".jpg").replace("-", ""):name;
			    		
			    	  
			    	    
			            System.out.println(folder);
			            
			            
			            File targetFile1 = new File(path, fileName);          
			            try {	
							file.transferTo(targetFile1);
							//上传本地图片到七牛云 云存储
							status=qiniuUtil.uploadQiNiuImg(path+"/"+fileName,fileName,force);
							
						} catch (IOException e) {
							
							 e.printStackTrace();
							return ResultDto.createError("上传失败");
						}
	
			              
			        }
				            //返回给前端七牛云访问的文件名
			        if(status==1){
			        	 return ResultDto.createSuccess(fileName);
			        }else{
			        	 return ResultDto.createError("上传失败");
			        }
			             
			 }
				
		   
				@ApiOperation(value="上传网络图片到七牛云")
				@RequestMapping(value="/Qiniu_uploadQiNiuNetImg",method=RequestMethod.GET)
				@ResponseBody
				public ResultDto uploadQiNiuNetImg(
						
						@ApiParam(value="图片URL",defaultValue="https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1546998663&di=3c458e0057c8fee89517a39b496da8f1&src=http://gss0.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/4bed2e738bd4b31c55b89ca084d6277f9e2ff821.jpg")@RequestParam(required=false)String img_url,
						@ApiParam(value = "网络访问的名字,要唯一,不然会失败")@RequestParam(required=false)String name
						)throws IOException{
					  //String path=request.getSession().getServletContext().getRealPath("/");

										
					 return qiniuUtil.uploadQiNiuNetImg(img_url,name);
				}
				
				
				
				@ApiOperation(value="获取该七牛 文件名的 文件信息")
				@RequestMapping(value="/Qiniu_qinNiufileInfo",method=RequestMethod.GET)
				@ResponseBody
				public ResultDto qinNiufileInfo(					
						@ApiParam(value = "网络访问的名字,要唯一,不然会失败")@RequestParam(required=false)String name
						) throws QiniuException{
					  //String path=request.getSession().getServletContext().getRealPath("/");

										
					 return qiniuUtil.qinNiufileInfo(name);
				}
				
				@ApiOperation(value="上传网络图片到七牛云 图片不经过自己的服务器 快")
				@RequestMapping(value="/Qiniu_uploadQiNiuNetImg_direct",method=RequestMethod.GET)
				@ResponseBody
				public ResultDto uploadQiNiuNetImg_direct(
						
						@ApiParam(value="图片URL",defaultValue="https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1546998663&di=3c458e0057c8fee89517a39b496da8f1&src=http://gss0.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/4bed2e738bd4b31c55b89ca084d6277f9e2ff821.jpg")@RequestParam(required=false)String img_url,
						@ApiParam(value = "网络访问的名字,要唯一,不然会失败")@RequestParam(required=false)String name
						)throws IOException{
					  //String path=request.getSession().getServletContext().getRealPath("/");

										
					 return qiniuUtil.uploadQiNiuNetImg_direct(img_url,name);
				}
				
				@ApiOperation(value=" 删除七牛云上面的  的文件")
				@RequestMapping(value="/Qiniu_qiNiuDeleteFile",method=RequestMethod.GET)
				@ResponseBody
				public ResultDto qiNiuDeleteFile(												
						@ApiParam(value = "网络访问文件名") @RequestParam(required=true)String name
						)throws IOException{
					

										
					 return qiniuUtil.qiNiuDeleteFile(name);
				}
				
				@ApiOperation(value=" CDN相关功能 文件刷新")
				@RequestMapping(value="/Qiniu_qiNiuCDNRefreshFile",method=RequestMethod.GET)
				@ResponseBody
				public ResultDto qiNiuCDNRefreshFile(												
						@ApiParam(value = "网络访问文件名") @RequestParam(required=true)String name
						)throws IOException{
					String[] strs=new String[]{name};
				

										
					 return qiniuUtil.qiNiuCDNRefreshFile(strs);
				}
				
				
				
				@ApiOperation(value="更新根据id作品的封面图")
				@RequestMapping(value="/updateArticleUrlbyid",method=RequestMethod.GET)
				@ResponseBody
				public ResultDto updateArticleUrlbyid(
						@ApiParam(value="作品id  required=必填")@RequestParam(required=true)int id,
						@ApiParam(value="作品封面图",defaultValue="12222222222")@RequestParam(required=false)String article_url
						
						){
					Integer b=articleMapper.updateArticleUrlbyid(id, article_url);

					

					
					
					 return ResultDto.createSuccess(b);
				}
				@ApiOperation(value="更新根据id作品的花絮")
				@RequestMapping(value="/updateHuaxuUrlbyid",method=RequestMethod.GET)
				@ResponseBody
				public ResultDto updateHuaxuUrlbyid(
						@ApiParam(value="作品id  required=必填")@RequestParam(required=true)int id,
						@ApiParam(value="作品封面图",defaultValue="12222222222")@RequestParam(required=false)String huaxu_url
						
						){
					Integer b=articleMapper.updateHuaxuUrlbyid(id, huaxu_url);

					

					
					
					 return ResultDto.createSuccess(b);
				}
	   

}
