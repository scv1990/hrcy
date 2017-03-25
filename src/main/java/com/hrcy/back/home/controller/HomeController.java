package com.hrcy.back.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台登录界面
 * @author admin
 *
 */
@Controller
public class HomeController {

	public void toHomePage(){
		
	}
	@RequestMapping(value="back/adlogin")
	public String adminLogin(){
		return "back/login";
	}
}
