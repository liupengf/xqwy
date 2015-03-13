package org.thcic.xqwy.fxzl.web.front;
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
@RequestMapping("/xqwy/jbxx/fxzl/")
public class Xqwy_fxzlFrontController{

	@RequestMapping(value = "/beforePageList")
	public String beforeQueryList(Model model) {

		return "/xqwy/jbxx/fxzl/fxzllist";
	}

	@RequestMapping(value = "/beforeAdd")
	public String beforeAdd(Model model) {
		return "/xqwy/jbxx/fxzl/add";
	}

	@RequestMapping(value = "/beforeEdit/{fxzlid}")
	public String beforeEdit(@PathVariable int fxzlid, Model model) {
		model.addAttribute("fxzlid", fxzlid);
		return "/xqwy/jbxx/fxzl/edit";
	}

	@RequestMapping(value = "/beforeView/{fxzlid}")
	public String beforeView(@PathVariable int fxzlid, Model model) {
		model.addAttribute("fxzlid", fxzlid);
		return "/xqwy/tccxx/fxzl/view";
	}

	

}

