package org.thcic.ejw.core.web.front;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * Main front Controller
 * 
 * 
 */
@Controller
public class MainController {

	/**
	 * 登录页
	 * 
	 * @param model
	 * @return
	 */
	/*
	 * @RequestMapping(value = "/login") public String login(Model model) {
	 * return "/common/login"; }
	 */
	/**
	 * 登录后首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/main")
	public String main(Model model) {
		return "/common/main";
	}

	/**
	 * 仅用于上传功能测试
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upload")
	public String upload(Model model) {
		return "/common/upload";
	}
}