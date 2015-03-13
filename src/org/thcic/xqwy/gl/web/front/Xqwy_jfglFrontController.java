package org.thcic.xqwy.gl.web.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thcic.xqwy.sfxm.service.Xqwy_sfxmService;

/**
 * 说明：增加，修改，删除xqwy_jfgl的前端处理类
 * 
 * @author liupengfei
 * @since 2015-03-10
 * @version 1.0
 */
@Controller
@RequestMapping("/xqwy/gl/jfgl")
public class Xqwy_jfglFrontController{
@Autowired
private Xqwy_sfxmService sfxmService;
	@RequestMapping(value = "/beforePageList")
	public String beforeQueryList() {
		return "/xqwy/gl/jfgl/jfgllist";
	}

	@RequestMapping(value = "/beforeAdd")
	public String beforeAdd(Model model) {
		model.addAttribute("sfxmlist", sfxmService.getAll());
		return "/xqwy/gl/jfgl/add";
	}

	@RequestMapping(value = "/beforeEdit/{p_id}")
	public String beforeEdit(@PathVariable int p_id, Model model) {
		model.addAttribute("jfid", p_id);
		model.addAttribute("sfxmlist", sfxmService.getAll());
		return "/xqwy/gl/jfgl/edit";
	}

	@RequestMapping(value = "/beforeView/{p_id}")
	public String beforeView(@PathVariable String p_id, Model model) {
		model.addAttribute("p_id", p_id);
		return "/gl/xqwy_jfglview";
	}

	

}

