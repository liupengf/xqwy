package org.thcic.xqwy.gl.web.front;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 说明：增加，修改，删除xqwy_zhtcw的前端处理类
 * 
 * @author liupengfei
 * @since 2015-03-10
 * @version 1.0
 */
@Controller
@RequestMapping("/xqwy/gl/zhtcw")
public class Xqwy_zhtcwFrontController{

	@RequestMapping(value = "/beforePageList")
	public String beforeQueryList() {
		return "/xqwy/gl/zhtcw/zhtcwlist";
	}

	@RequestMapping(value = "/beforeAdd")
	public String beforeAdd() {
		return "/xqwy/gl/zhtcw/add";
	}

	@RequestMapping(value = "/beforeEdit/{p_id}")
	public String beforeEdit(@PathVariable String p_id, Model model) {
		model.addAttribute("sfz", p_id);
		return "/xqwy/gl/zhtcw/edit";
	}

	@RequestMapping(value = "/beforeView/{p_id}")
	public String beforeView(@PathVariable String p_id, Model model) {
		model.addAttribute("p_id", p_id);
		return "/gl/xqwy_zhtcwview";
	}

	

}

