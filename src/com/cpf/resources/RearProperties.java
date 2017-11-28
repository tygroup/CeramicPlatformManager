package com.cpf.resources;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class RearProperties
{
  Properties props = new Properties();

  public String getpath(String name) { String path = "";
    try {
      this.props.load(getClass().getClassLoader().getResourceAsStream(
        "path.properties"));
      path = this.props.getProperty(name);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return path;
  }

  public String getValue(String filename, String name)
  {
    String value = "";
    try {
      this.props.load(getClass().getClassLoader().getResourceAsStream(filename));
      value = this.props.getProperty(name);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return value;
  }

  public Map readInMap(String filePath)
  {
    Map map = new HashMap();
    try {
      this.props.load(getClass().getClassLoader().getResourceAsStream(filePath));
      Enumeration en = this.props.propertyNames();
      while (en.hasMoreElements()) {
        String key = (String)en.nextElement();
        String property = this.props.getProperty(key);
        map.put(key, property);
      }
      this.props.clear();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return map;
  }
  public static void main(String[] args) {
    RearProperties a = new RearProperties();
    String b = a.getpath("address");
    System.out.println(b);
  }
}