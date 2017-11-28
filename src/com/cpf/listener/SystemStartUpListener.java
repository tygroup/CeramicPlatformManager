package com.cpf.listener;

import com.cpf.resources.ConfigUtilss;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



public class SystemStartUpListener
  implements ServletContextListener
{
	private static  final String RESOURCE_CONFIG = "config";
	private static final String RESOURCE_IMAGESFILE = "imagesFile";
  public void contextDestroyed(ServletContextEvent arg0)
  {
  }

  public void contextInitialized(ServletContextEvent arg0)
  {
    ServletContext context = arg0.getServletContext();
	ConfigUtilss config = new ConfigUtilss(RESOURCE_CONFIG);
	ConfigUtilss imagesFile = new ConfigUtilss(RESOURCE_IMAGESFILE);
	 
	context.setAttribute("adimg",imagesFile.getConfigProperty("adimg"));
	context.setAttribute("goodsimg",imagesFile.getConfigProperty("goodsimg"));
	context.setAttribute("dataimg",imagesFile.getConfigProperty("dataimg")); 
	context.setAttribute("adshowimg",imagesFile.getConfigProperty("adshowimg")); 
	context.setAttribute("unitlogo",imagesFile.getConfigProperty("unitlogo")); 
	context.setAttribute("aboutme",imagesFile.getConfigProperty("aboutme"));
	context.setAttribute("nurse",imagesFile.getConfigProperty("nurse"));
	context.setAttribute("unitcodeimg",imagesFile.getConfigProperty("unitcodeimg"));
	context.setAttribute("unitfiles",imagesFile.getConfigProperty("unitfiles"));
	context.setAttribute("datafiles",imagesFile.getConfigProperty("datafiles"));
    //String imgUploadUrl = config.getConfigProperty("imgUploadUrl");
    String imgDisplayUrl = config.getConfigProperty("imgDisplayUrl");
    String fileUploadUrl = config.getConfigProperty("fileUploadUrl");
    String fileDownloadUrl = config.getConfigProperty("fileDownloadUrl");
    String flag = config.getConfigProperty("flag");
    String imgSize = config.getConfigProperty("size");
   

    context.setAttribute("flag", flag);
    //context.setAttribute("imgUploadUrl", imgUploadUrl);
    context.setAttribute("imgDisplayUrl", imgDisplayUrl);
    context.setAttribute("fileUploadUrl", fileUploadUrl);
    context.setAttribute("fileDownloadUrl", fileDownloadUrl);
    context.setAttribute("imgSize", imgSize);
    
  
    
	context.setAttribute("FILEUPLOADURL",
			config.getConfigProperty("fileUploadUrl"));
	context.setAttribute("FLAG", config.getConfigProperty("flag"));
	//视频
	context.setAttribute("UPLOADFILETYPEVIDEO",
			config.getConfigProperty("UploadFileTypeVideo"));
	context.setAttribute("UPLOADFILETYPEAUDIO",
			config.getConfigProperty("UploadFileTypeAudio"));
	//图片
	context.setAttribute("UPLOADFILETYPEPICTURE",
			config.getConfigProperty("UploadFileTypePicture"));
	//文档
	context.setAttribute("UPLOADFILETYPEDOCUMENT",
			config.getConfigProperty("UploadFileTypeDocument"));
	context.setAttribute("UPLOADFILETYPEPICTURESIZE",
			config.getConfigProperty("UploadFileTypePictureSize"));
	context.setAttribute("UPLOADFILETYPEFILESIZE",
			config.getConfigProperty("UploadFileTypeFileSize"));
	context.setAttribute("UPLOADFILETYPEPICTURELIMIT",
			config.getConfigProperty("UploadFileTypePictureLimit"));
	context.setAttribute("UPLOADFILETYPEFILELIMIT",
			config.getConfigProperty("UploadFileTypeFileLimit"));
	
	
  }
}