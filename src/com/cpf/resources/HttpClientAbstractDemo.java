package com.cpf.resources;

import java.io.File;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpClientAbstractDemo
{
  private static RearProperties rearPro = null;

  public static String PostFile(File file, String httpurl, StringBody savepath, String imageFileName, String size, String type)
    throws Exception
  {
    rearPro = new RearProperties();

    String postpath = rearPro.getValue("config.properties", httpurl);

    String filename = "";

    filename = DateUtil.getStringTodayByName();

    int index = imageFileName.lastIndexOf(".");

    filename = filename + imageFileName.substring(index);

    HttpClient httpclient = new DefaultHttpClient();

    httpclient.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);

    HttpPost httppost = new HttpPost(postpath);

    MultipartEntity mpEntity = new MultipartEntity();
    ContentBody cbFile = new FileBody(file, "filename");
    mpEntity.addPart("tempPathFile", cbFile);
    mpEntity.addPart("filePath", savepath);
    mpEntity.addPart("fileFileName", new StringBody(filename));
    mpEntity.addPart("flag", new StringBody("c0e63f0efa324fca82870c33831112c0"));
    mpEntity.addPart("size", new StringBody(size));
    mpEntity.addPart("type", new StringBody(type));
    httppost.setEntity(mpEntity);
    HttpResponse response = httpclient.execute(httppost);
    HttpEntity resEntity = response.getEntity();
    if (resEntity != null) {
      filename = EntityUtils.toString(resEntity);
    }
    if (resEntity != null) {
      resEntity.consumeContent();
    }

    httpclient.getConnectionManager().shutdown();
    httpclient.getConnectionManager().closeExpiredConnections();
    return filename;
  }
}