package com.cpf.resources;

import java.io.File;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;

public class UploadImg {
	/**
	 * 图片上传接口
	 * 
	 * @param targetURL
	 *            图片服务器请求接口
	 *            例如：http://localhost:8080/NetWorkServer/servlet/UploadServlet
	 * @param imgpath
	 *            要上传文件 
	 *            例如：String[] imgpath = new String[] {"e:\\test.png","e:\\aa.jpg" };
	 * @param flag
	 *            上传合法校验标识码
	 * @param size
	 *            生成缩放图片的宽度
	 * @return 
	 *         上传到服务器后的相对路径，多文件路径逗号分割,为空字符串表示上传失败。
	 *         例如：/32a/9998d49946fd83db6de72f82a666.png,/199/90a6148748ec9eca093bab356332.jpg
	 */
	public String UploadImg(String targetURL, String[] imgpath, String flag,
			int size) {
		targetURL = targetURL + "?flag=" + flag + "&size=" + size+"&filePath=/ckeditor";
		int count = imgpath.length;
		PostMethod filePost = new PostMethod(targetURL);
		String response = "";
		try {
			Part[] parts = new Part[count];
			for (int i = 0; i < count; i++) {
				File file = new File(imgpath[i]);
				parts[i] = new FilePart("file", file);
			}
			filePost.setRequestEntity(new MultipartRequestEntity(parts,
					filePost.getParams()));
			HttpClient client = new HttpClient();
			client.getHttpConnectionManager().getParams()
					.setConnectionTimeout(3000);
			int status = client.executeMethod(filePost);
			if (status == HttpStatus.SC_OK) {
				response = new String(filePost.getResponseBodyAsString()
						.getBytes("ISO-8859-1"), "UTF-8");
				filePost.releaseConnection();
				// 上传成功
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			filePost.releaseConnection();
		}
		return response;
	}

}
