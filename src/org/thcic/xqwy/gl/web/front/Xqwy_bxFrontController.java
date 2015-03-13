package org.thcic.xqwy.gl.web.front;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 说明：增加，修改，删除xqwy_bx的前端处理类
 * 
 * @author liupengfei
 * @since 2015-03-10
 * @version 1.0
 */
@Controller
@RequestMapping("/xqwy/gl/bx")
public class Xqwy_bxFrontController{

	@RequestMapping(value = "/beforePageList")
	public String beforeQueryList() {
		return "/xqwy/gl/bx/bxlist";
	}

	@RequestMapping(value = "/beforeAdd")
	public String beforeAdd() {
		return "/xqwy/gl/bx/add";
	}

	@RequestMapping(value = "/beforeEdit/{bxid}")
	public String beforeEdit(@PathVariable int bxid, Model model) {
		model.addAttribute("bxid", bxid);
		return "/xqwy/gl/bx/edit";
	}

	@RequestMapping(value = "/beforeView/{p_id}")
	public String beforeView(@PathVariable String p_id, Model model) {
		model.addAttribute("p_id", p_id);
		return "/xqwy/gl/bx/xqwy_bxview";
	}

	

}

