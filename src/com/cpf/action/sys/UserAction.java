package com.cpf.action.sys;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.cpf.action.BaseAction;
import com.cpf.bean.sys.Users;
import com.cpf.service.I.sys.UserService;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction {
	@Autowired
	private UserService service;
	private Users user;

	/**
	 * 用户登录 校验
	 * 
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public String login() throws ClassNotFoundException, InstantiationException, IllegalAccessException   {
		HttpServletRequest request = ServletActionContext.getRequest();
		 // 验证码
		//String randcode = request.getParameter("rand");
		Object code = request.getSession().getAttribute("rand");
		//String sessioncode = code == null ? "" : code.toString();
		/*// 验证码不通过则返回登陆页面
		if (!sessioncode.equals(randcode)) {

			message = "验证码错误!";
			return "input";
		} 
		*/
		user = service.checkLogin(user);
		Users  uu =new Users();
		 Random random = new Random();
			uu.setName("test");
			uu.setUserid("test"+random.nextInt());
		service.save(uu);
		if (user != null) {
				return "success";
		} else {
			return "input";
		}
	} 
 

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
 

}
