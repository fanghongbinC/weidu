package com.baopinghui.bin.qiniu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.UUID;

import com.baopinghui.bin.dto.ResultDto;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.qiniu.cdn.CdnManager;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FetchRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;

public class qiniuUtil {
	public  static String accessKey = "5NwL-fG20Yp0nN_hYxxEokw6w9FMIkp9OnIwWS7T";
	public static String secretKey = "2RHkAjOBJ5lWek00gZI8wIHgaacSyOhOwoYEeX1w";
	public static String bucket = "alicbin";
	//构造一个带指定Zone对象的配置类
	static Configuration cfg = new Configuration(Zone.zone0()); //华东区域
	//...其他参数参考类注释  //构建一个非断点续传的上传对象
	static UploadManager uploadManager = new UploadManager(cfg);
	
	
	//默认不指定key的情况下，以文件内容的hash值作为文件名
	
	static Auth auth = Auth.create(accessKey, secretKey);
	static String upToken = auth.uploadToken(bucket);
	
	static BucketManager bucketManager = new BucketManager(auth, cfg);   
	
	static CdnManager c = new CdnManager(auth);   //CDN管理
/**
 * 上传本地图片到七牛云 云存储
  * @param path   本地的图片的路径 含文件名
     * @param filename  文件名
     * @param force 文件重复是否覆盖
	**/
	 public   static int uploadQiNiuImg(String path,String filename,boolean force){
		 
		 try {
			    Response response = uploadManager.put(path, filename, upToken);
			    //解析上传成功的结果
			    DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
			    System.out.println(putRet.key);
			    System.out.println(putRet.hash);
			} catch (QiniuException ex) {
				
			    Response r = ex.response;
			    System.err.println(Thread.currentThread().getStackTrace()[1].getClassName()+"七牛上传图片错误"+r.toString());
				   if(force&&r.statusCode==614){ //该文件名已经存在
					   
					   qiNiuDeleteFile(filename);  //删除掉图片
					   
					   uploadQiNiuImg(path,filename,force); //重新上传
					   
					 String []  strs=new String[]{filename};
					    qiNiuCDNRefreshFile(strs);
					   return 1;
				   }
				  
			  
			    return 0;
			}
		 return 1;
	 }
	 /**
	  * 上传网络图片到七牛云 云存储
	   * @param neturl   网络图片的url路径
	      * @param name  网络访问的文件名,如果为null或空的话,会自动生成唯一文件名
	 	**/ 
	
	 public static ResultDto  uploadQiNiuNetImg(String neturl,String name) throws IOException{
		 
		 File folder=new File("D:/TomCat/upload");
		 File file=null;
		 String fileName="";
		      //创建文件夹
		 if(!folder.exists()){
			 boolean b =  folder.mkdirs();
		 }
		 InputStream in=null;
		 FileOutputStream fo = null;
		 try {
			URL url=new URL(neturl);
			in=url.openStream();    //1.获取打开网络
			  fileName =Strings.isNullOrEmpty(name)?(UUID.randomUUID() + ".jpg").replace("-", ""):name;
			  file = new File(folder,fileName);
			 fo = new FileOutputStream(file);
			 byte[] buf = new byte[1024];
			 int length = 0;
			   //开始写入文件
				while ((length = in.read(buf, 0, buf.length)) != -1) {
					// logger.info("length: " + length);
					fo.write(buf, 0, length);
				}
			
		} finally {   //关闭流
			if(in!=null){
				in.close();
			}
			if(fo!=null){
				fo.close();
			}	
			
		}
		 uploadQiNiuImg(folder+"/"+fileName, fileName,false); //开始上传七牛云
		 if(file.isFile()){
			file.delete(); 
		 }
	
	   return   ResultDto.createSuccess(fileName) ; //返回生成的网络访问文件名
	 }
	 /**
	  * 上传网络图片到七牛云 云存储 图片不经过自己的服务器
	  * 拉去别的网络资源
	   * @param neturl   网络图片的url路径
	      * @param name  网络访问的文件名,如果为null或空的话,会自动生成唯一文件名
	 * @throws QiniuException 
	 	**/ 
	       
		 public static ResultDto  uploadQiNiuNetImg_direct(String neturl,String name) throws QiniuException{
			 String filename=Strings.isNullOrEmpty(name)?(UUID.randomUUID() + ".jpg").replace("-", ""):name;
			  FetchRet fetchRet = bucketManager.fetch(neturl, bucket, filename); 
			  
			return ResultDto.createSuccess(filename);   
			 
		 }
/**
 *  返回该文件名的 文件信息
 * @param key_name 七牛云 云储存的 文件名	 
	 **/
	 public static ResultDto  qinNiufileInfo(String key_name)throws QiniuException{
		 
		 FileInfo fileInfo = bucketManager.stat(bucket, key_name); //获取文件的信息
		
		return ResultDto.createSuccess(fileInfo);
	 }
	 
 /**
  *  删除七牛云上面的  的文件
  * @param key_name 七牛云 云储存的 文件名	 
 	 **/
		 public static ResultDto  qiNiuDeleteFile(String key_name){
			 
			 try {
				    bucketManager.delete(bucket, key_name);
				} catch (QiniuException ex) {
				    //如果遇到异常，说明删除失败
				    System.err.println("删除失败"+ex.code());
				    System.err.println("删除失败"+ex.response.toString());
				    return ResultDto.createError("删除失败");
				}
			 return ResultDto.createSuccess("删除成功");
		 }
 /**
  *  CDN相关功能 文件刷新
  * @param key_name 七牛云 云储存的 文件名数组	 
 	 **/
				 public static ResultDto  qiNiuCDNRefreshFile(String[] key_name){
					 
					 try {
						    c.refreshUrls(key_name);
						} catch (QiniuException ex) {
						    //如果遇到异常，说明删除失败
							
						    System.err.println("刷新失败"+ ex.code());
						    System.err.println("刷新失败"+ex.response.toString());
						    
						    return ResultDto.createError("刷新失败");
						}
					 return ResultDto.createSuccess("刷新成功");
				 }
		 
}
