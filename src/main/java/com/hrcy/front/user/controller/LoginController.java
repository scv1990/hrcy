package com.hrcy.front.user.controller;


import java.io.IOException;
import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.hrcy.front.user.domain.User;
import com.hrcy.front.user.service.UserService;


/**
 * 
 * @author admin
 * 前台用户登陆
 */
@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="welcome")
	public String toLoginPage(HttpServletRequest servlet){
		Locale local = servlet.getLocale();
		System.out.println("locale==" + local.toString());
		Principal pal = servlet.getUserPrincipal();
		System.out.println("tologinPage=="+pal.toString());
		return "welcome";
	}
	
	@RequestMapping(value="front/user/login")
	public String toLoginPage2(HttpServletRequest servlet){
		System.out.println("tologinPage2");
		return "front/user/login";
	}
	
	@RequestMapping(value="front/user/checkLogin")
	public String loginPage(HttpServletRequest request,User user){
		
		Boolean loginSucess = userService.hasMatchUser(user);
		System.out.println("isloginsuccess"+ loginSucess);
		if(loginSucess){
			request.getSession().setAttribute("Info","");
			return "welcome";
		}else{
			request.getSession().setAttribute("Info","请重新输入!!");
			return "redirect:/front/user/login.do";
		}
		
	}
	@RequestMapping(value="/front/user/dotest")
	public ModelAndView getView(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/front/user/welcome");
		view.addObject("username", "zhangsan");
		return view;
	}
	@ResponseBody
	@RequestMapping(value="/getImage/{imageId}")
	public byte[] handle(@PathVariable("imageId") String imageId) throws IOException{
		System.out.println("iamgeId==" + imageId);
		Resource rs = new ClassPathResource("/" + imageId + ".jpg");
		byte[] fileData = FileCopyUtils.copyToByteArray(rs.getInputStream());
		return fileData;
	}
	
	@RequestMapping(value="/handle2")
	public String handle2(HttpEntity<String> entity) throws IOException{
		long len = entity.getHeaders().getContentLength();
		System.out.println("requestBody len==" + len);
		System.out.println("requestBody==" + entity.getBody());
		return "welcome";
	}
	
	@RequestMapping(value="/handle4")
	public String handle4(@RequestBody String body) throws IOException{
		
		System.out.println("requestBody==" + body);
		return "welcome";
	}
	
	@RequestMapping(value="/handle3")
	public String handle3(WebRequest request) throws IOException{
		System.out.println(request.getParameter("userName"));
		return "welcome";
	}
}
