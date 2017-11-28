package com.cpf.service.impl.sys;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpf.bean.sys.Users;
import com.cpf.dao.I.sys.UserMapper;
import com.cpf.service.I.sys.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	 @Autowired
	private UserMapper dao;

	public Users checkLogin(Users user) {
		return dao.checkLogin(user);
	}
	public void save(Users user) {
		dao.save(user); 
		System.out.println("...into trasations...");
		String a=null;
		if(a.equals("1")){
			System.out.println("....a equals 1...");
		}
		
	}
	 
	  

}