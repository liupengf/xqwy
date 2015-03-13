package org.thcic.xqwy.tccxx.web.front;
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
@RequestMapping("/xqwy/jbxx/tccxx/")
public class Xqwy_tccxxFrontController{

	@RequestMapping(value = "/beforePageList")
	public String beforeQueryList(Model model) {

		return "/xqwy/jbxx/tccxx/tccxxlist";
	}

	@RequestMapping(value = "/beforeAdd")
	public String beforeAdd(Model model) {
		return "/xqwy/jbxx/tccxx/add";
	}

	@RequestMapping(value = "/beforeEdit/{xxid}")
	public String beforeEdit(@PathVariable String xxid, Model model) {
		model.addAttribute("xxid", xxid);
		return "/xqwy/jbxx/tccxx/edit";
	}

	@RequestMapping(value = "/beforeView/{xxid}")
	public String beforeView(@PathVariable String xxid, Model model) {
		model.addAttribute("xxid", xxid);
		return "/xqwy/tccxx/jbxx/view";
	}

	

}

