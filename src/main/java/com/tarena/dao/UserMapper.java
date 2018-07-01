package com.tarena.dao;

import com.tarena.entity.User;

public interface UserMapper {
    /**
     * 登录的数据方法
     * @param user
     * @return
     */
	public String login(User user);

}
