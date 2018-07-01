package com.tarena.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tarena.service.UserService;
import com.tarena.vo.Result;

@Controller
@RequestMapping("user/")
public class UserController {
	@Resource(name="userService")
	private UserService userService;
	@RequestMapping(value="login/{loginName}/{password}",method=RequestMethod.GET)
	@ResponseBody
	public Result login(
			@PathVariable("loginName") String loginName,
			@PathVariable("password") String password,
			HttpSession session){
		System.out.println(loginName+"   "+password);
		Result result=null;
		
		result=this.userService.login(loginName,password);
		if(result.getStatus()==1){
			session.setAttribute("loginName", loginName);
		}
		return result;
	}
}
