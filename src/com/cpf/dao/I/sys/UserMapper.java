package com.cpf.dao.I.sys;

import java.util.Map;

import com.cpf.bean.sys.Users;
import com.cpf.dao.BaseDAO;



public interface UserMapper extends BaseDAO<Users, String> {
	/**
	 * 登录用户账户 密码校验
	 * @param user user对象 对应表users
	 * @return 校验成功返回 user对象  否则返回null
	 */
	public Users checkLogin(Users user);

	public void resetPassBatch(Map<String,Object> params);
}
