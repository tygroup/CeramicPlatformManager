package com.cpf.service.I.sys;


import com.cpf.bean.sys.Users;




public interface UserService{
  
	/**
	 * 检查用户登录 用户名 密码
	 * @param user 用户对象，对应表Users
	 * @return 若验证通过返回对应用户对象，对应表Users，否则返回null.
	 */
	public Users checkLogin(Users user);
	
	public void save(Users user);
	
	 
}
