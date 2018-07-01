package com.tarena.service;

import com.tarena.vo.Result;

public interface UserService {
	/**
	 * 登录的业务方法
	 * @param loginName  用户名
	 * @param password   密码
	 * @return Result对象
	 */
	public Result login(String loginName, String password);

}
