package org.thcic.xqwy.gl.web.front;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 说明：增加，修改，删除xqwy_ts的前端处理类
 * 
 * @author liupengfei
 * @since 2015-03-10
 * @version 1.0
 */
@Controller
@RequestMapping("/xqwy/gl/ts")
public class Xqwy_tsFrontController{

	@RequestMapping(value = "/beforePageList")
	public String beforeQueryList() {
		return "/xqwy/gl/ts/tslist";
	}

	@RequestMapping(value = "/beforeAdd")
	public String beforeAdd() {
		return "/xqwy/gl/ts/add";
	}

	@RequestMapping(value = "/beforeEdit/{p_id}")
	public String beforeEdit(@PathVariable int p_id, Model model) {
		model.addAttribute("tsid", p_id);
		return "/xqwy/gl/ts/edit";
	}

	@RequestMapping(value = "/beforeView/{p_id}")
	public String beforeView(@PathVariable String p_id, Model model) {
		model.addAttribute("p_id", p_id);
		return "/gl/xqwy_tsview";
	}

	

}

