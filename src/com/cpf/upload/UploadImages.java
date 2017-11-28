package com.cpf.upload;


import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cpf.resources.HttpClientAbstractDemo;
import com.cpf.resources.ImageUtil;
import com.cpf.resources.RearProperties;


@Controller
@Scope("prototype")
public class UploadImages {
		private  File image; // 图片文件
		private  String  imageFileName; 
		private  File  files;
		private  String llq;//兼容ie浏览器
	  	private  String mark;
	  	private  String path;
		private final static String [] type_image= {"jpg","jpeg","png","gif","bmp"};
		private final static String [] type_file = {"txt","doc","docx","xls","xlsx","jpg","png","jpeg","bmp","gif","pdf","ppt","pptx",};
	  	
		/****
		 * 上传文件 2015-09-25
		 * @author jml
		 *  
		 */
		public  void  GetMultiImage() {  
			PrintWriter out = null;
			//System.out.println("imageFileName:"+image.getAbsolutePath());
			try {
				
				//2016/01/07闫贵锁修改 防止乱码
				HttpServletResponse 	response=ServletActionContext.getResponse();
				 response.setContentType("text/html;charset=utf-8;");
				out = response.getWriter();
				
				if(imageFileName != null){
				    
					String result =	getsize();
					
					boolean type_result = getType();
					
					if(!result.equals("1")){
						
						out.print(result);
						
					}else if( type_result == false){
						
						out.print("您上传的文件格式有误，请重新上传！");
						
					}else{
						 
						out.print(upload());
						
					}	
				}else{
					out.print("您上传的图片不符合要求，请重新上传！");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(out!=null){
				out.flush();
				out.close();
				}
			}
	}
		/***
		 * 获取并判断文件大小，宽高
		 * @return
		 * @throws Exception
		 */
		private  String  getsize() throws Exception{
			String result ="1";
			long size =	image.length();
			
			if(mark != null && mark.equals("0"))
			  {  
				 /* BufferedImage bufferedImg = ImageIO.read(new FileInputStream(image));
				    int imgWidth = bufferedImg.getWidth();
				    int imgHeight = bufferedImg.getHeight();*/
				  if(size > 6 * 1024 * 1024){
					  result = "上传图片不能大于6M！";
				  }/*else if(imgWidth<700){
					  result = "上传图片宽度必须大于700！";
				  }else if(imgHeight<700){
					  result = "上传图片高度必须大于700！";
				  }*/else{
					  return result;
				  }
				
				  } 
		    if(mark != null && mark.equals("1"))
		    {
			  
			  if(size>400 * 1024 * 1024){
				  result = "上传文件不能大于400M！";
			  }else{
				  return result;
			  }
		  } 
			 return result;
			  
		  }
		
		/***
		 * 获取并判断文件类型
		 * @return
		 */
		private boolean getType(){
			String kzm = imageFileName.substring(imageFileName.lastIndexOf(".")).toLowerCase().replace(".", "");
			
			String [] types = {};
			
			boolean result = false;
			
			if(mark != null && mark.equals("0")){
				
				types = type_image;
			
			}else  if(mark != null && mark.equals("1")){
				
				//types = type_file;
				return true;
			
			}
			for(String str: types){
				 if(str.toLowerCase().equals(kzm.toLowerCase())){
					  result = true;
					  break;
				}
			}
			return result;
		}
		
		/***
		 * 开始上传文件，返回文件路径
		 * @return
		 * @throws Exception
		 */
		private String  upload() throws Exception{
			
			String picpath="";
			
			StringBody body = null ;
			
			String strbody = null;
			
			RearProperties rearPro = new RearProperties();
			
			strbody = rearPro.getValue("imagesFile.properties", path);
			
			body = new  StringBody(strbody);
			if(mark != null && mark.equals("0")){
				ImageUtil.resize(image, new File(image.getAbsolutePath()));
			}
			
			String size = rearPro.getValue("config.properties", "size");
		    if(size==null ||size.equals("")){
		    	size="48";
		    }
			picpath =HttpClientAbstractDemo.PostFile(image,"imgUploadUrl",body,imageFileName.toLowerCase(), size,mark ); 
			
			String oo= strbody + "/" + picpath.trim();
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			if (llq != null && "ie".equals(llq)) {
				JSONArray json = JSONArray.fromObject(oo);
				return json+"";
			}else{
				return oo;
			}
		}
		
		public File getImage() {
			return image;
		}

		public void setImage(File image) {
			this.image = image;
		}

		public String getImageFileName() {
			return imageFileName;
		}

		public void setImageFileName(String imageFileName) {
			this.imageFileName = imageFileName;
		}

		/**
		 * @param files the files to set
		 */
		public void setFiles(File files) {
			this.files = files;
		}

		/**
		 * @return the files
		 */
		public File getFiles() {
			return files;
		}

		/**
		 * @param llq the llq to set
		 */
		public void setLlq(String llq) {
			this.llq = llq;
		}

		/**
		 * @return the llq
		 */
		public String getLlq() {
			return llq;
		}

		public void setMark(String mark) {
			this.mark = mark;
		}

		public String getMark() {
			return mark;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
	}
