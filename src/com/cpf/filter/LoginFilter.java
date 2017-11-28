package com.cpf.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.cpf.bean.sys.Users;



public class LoginFilter implements Filter{
	public void destroy(){
	}
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,ServletException{
    	HttpSession session=((HttpServletRequest)request).getSession();
    	((HttpServletResponse)response).setHeader("Pragma","No-cache");          
    	((HttpServletResponse)response).setHeader("Cache-Control","no-cache");   
    	((HttpServletResponse)response).setHeader("Cache-Control", "no-store");   
    	((HttpServletResponse)response).setDateHeader("Expires",0);
    	Users	user = (Users)ServletActionContext.getRequest().getSession().getAttribute("user");
    	String url=(((HttpServletRequest)request).getRequestURI());
    	if(url.endsWith("/login.jsp")||url.endsWith("/AsManager/")||url.endsWith("/image.jsp")){
    		chain.doFilter(request, response);
    	}else{
    		if(user==null){
    			((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath()+"/login.jsp");
    		}else{
    			chain.doFilter(request, response);
    		}
    	}
    }
    public void init(FilterConfig filterConfig)throws ServletException{
    	
    }
}
