package com.cpf.upload;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadFiles extends ActionSupport implements  ServletContextAware{
	/**
	 * 下载文件
	 */
	private static final long serialVersionUID = 1L;

		private ServletContext context;  
	  
	    private String filename;  
	    private String filePath;  
	  
	    private String mimeType;  
	  
	    private InputStream inStream;  
	  
	    @Override  
	    public String execute() throws Exception {  
	    //	PrintWriter print = ServletActionContext.getResponse().getWriter();
	    	filename=filename.replace("/studyfile/", "");
	        mimeType = context.getMimeType(filename);
	      //  print.print(mimeType);
	      //  print.flush();
	      //  print.close();
	        return SUCCESS;  
	    }  
	  
	    public InputStream getInStream() {  
	        inStream = getDownloadFile(filePath); 
	        if (inStream == null) {  
	            inStream = new ByteArrayInputStream("Sorry!".getBytes());  
	        }  
	        return inStream;  
	    }  
	    public InputStream getDownloadFile(String strRemoteFileUrl) { 
	        HttpClient client = new HttpClient();  
	        GetMethod httpGet = new GetMethod(strRemoteFileUrl); 
	        InputStream in  = null; 
	        try { 
	            int intResponseCode = client.executeMethod(httpGet);
	            if(intResponseCode==404){
	            	return null;
	            }
	            in  = httpGet.getResponseBodyAsStream(); 
	        } catch (HttpException e) { 
	        	e.printStackTrace();
	        } catch (IOException e) { 
	        	e.printStackTrace();
	        }   
	        return in;   
	    }

	    public String getMimeType() {  
	        return mimeType;  
	    }  
	  
	    public void setFilename(String filename) {  
	        try {  
	            this.filename = new String(filename.getBytes("ISO8859-1"),"UTF-8");  
	        } catch (UnsupportedEncodingException e) {  
	        }  
	    }  
	  
	    public String getFilename() {  
	        try {  
	            return new String(filename.getBytes(),"ISO8859-1");  
	        } catch (UnsupportedEncodingException e) {  
	            return this.filename;  
	        }  
	    }  
	  
	    public void setServletContext(ServletContext context) {  
	        this.context = context;  
	    }

		public String getFilePath() {
			return filePath;
		}

		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}  
	  
}
