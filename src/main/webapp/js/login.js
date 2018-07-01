//@ sourceURL=login.js
$(function(){
	console.log("login.js");
	//每次加载login.html,都要从cookie取出用户名,并赋值给用户名的框
	$("#inputName").val(getCookie("loginName"));
	$(".container form").submit(function(){
		return login();
	});
});
function login(){
	alert("login()");
	//获取页面的数据
	var loginName=$("#inputName").val();
	var password=$("#inputPassword").val();
	var remember=$(".container form input[type=checkbox]").get(0).checked;
	alert(loginName+"   "+password+"   "+remember);
	//根据页面的数据做异步请求
	$.ajax({
		url:basePath+"user/login/"+loginName+"/"+password,
		type:"get",
		dataType:"json",
		success:function(result){
			if(result.status==1){
				//登录成功  location对象是浏览器的地址栏对象
				if(remember){
					//记住密码打对勾 cookie   loginName=wt_zss@126.com
					addCookie("loginName",loginName,5);
				}
				window.location.href="index.html";
				
			}else if(result.status==0){
				//登录失败
				alert(result.message);
			}
		},
		error:function(){
			alert("请求失败!");
		}
	});
	
	return false;
}