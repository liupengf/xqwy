package org.thcic.xqwy.zhxx.web.front;
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
@RequestMapping("/xqwy/jbxx/zhxx/")
public class Xqwy_zhxxFrontController{

	@RequestMapping(value = "/beforePageList")
	public String beforeQueryList(Model model) {

		return "/xqwy/jbxx/zhxx/zhxxlist";
	}

	@RequestMapping(value = "/beforeAdd")
	public String beforeAdd(Model model) {
		return "/xqwy/jbxx/zhxx/add";
	}

	@RequestMapping(value = "/beforeEdit/{sfz}")
	public String beforeEdit(@PathVariable String sfz, Model model) {
		model.addAttribute("sfz", sfz);
		return "/xqwy/jbxx/zhxx/edit";
	}

	@RequestMapping(value = "/beforeView/{xxid}")
	public String beforeView(@PathVariable String sfz, Model model) {
		model.addAttribute("sfz", sfz);
		return "/xqwy/tccxx/zhxx/view";
	}

	

}

