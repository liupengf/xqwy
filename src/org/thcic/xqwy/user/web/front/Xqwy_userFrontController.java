package org.thcic.xqwy.user.web.front;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 说明：增加，修改，删除教务办公发文表的前端处理类
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Controller
@RequestMapping("/xqwy/xtgl/user/")
public class Xqwy_userFrontController{

	@RequestMapping(value = "/beforePageList")
	public String beforeQueryList(Model model) {

		return "/xqwy/xtgl/user/userlist";
	}

	@RequestMapping(value = "/beforeAdd")
	public String beforeAdd(Model model) {
		return "/xqwy/xtgl/user/add";
	}

	@RequestMapping(value = "/beforeEdit/{username}")
	public String beforeEdit(@PathVariable String username, Model model) {
		model.addAttribute("username", username);
		return "/xqwy/xtgl/user/edit";
	}

	@RequestMapping(value = "/beforeView/{username}")
	public String beforeView(@PathVariable String username, Model model) {
		model.addAttribute("username", username);
		return "/xqwy/xtgl/user/view";
	}
	
	@RequestMapping(value = "/beforeBf")
	public String beforeBf() {
		
		return "/xqwy/xtgl/xtbf";
	}
	

}

