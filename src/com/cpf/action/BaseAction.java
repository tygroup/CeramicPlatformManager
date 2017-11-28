package com.cpf.action;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.cpf.resources.HtmlEncoder;
import com.cpf.resources.PageListData;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletResponseAware{
	 private javax.servlet.http.HttpServletResponse response; 
	protected PageListData pageListData;// 分页组件
	protected int currentPage = 1;// 当前页
	protected int pageSize = 15;// 每页显示的数目
	protected int totalCount=0;//记录总数
	protected String message="";//提示信息
	protected String jumpAction;
	protected String pram="";
	 
	 

	public String getPram() {
		return pram;
	}

	public void setPram(String pram) {
		this.pram = pram;
	}

	public String getJumpAction() {
		return jumpAction;
	}

	public void setJumpAction(String jumpAction) {
		this.jumpAction = jumpAction;
	}

	public PageListData getPageListData() {
		return pageListData;
	}

	public void setPageListData(PageListData pageListData) {
		this.pageListData = pageListData;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	protected void returnMessage(){
		 response.setContentType("text/html;charset=UTF-8");    
         response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码    
        PrintWriter out;
		try {
			out = response.getWriter();
		
        out.print("<script>alert('"+message+"')</script>");     
        out.print("<script>window.location.href='"+jumpAction+".action"+(pram.length()>0 ? ("?"+HtmlEncoder.xssEncode(pram)):"" )+"'</script>");  
        out.flush();    
        out.close();    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	 
	 
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		 this.response = response; 
	}

	
}
