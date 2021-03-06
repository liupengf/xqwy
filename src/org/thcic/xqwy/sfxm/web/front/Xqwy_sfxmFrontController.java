package org.thcic.xqwy.sfxm.web.front;
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
@RequestMapping("/xqwy/jbxx/sfxm/")
public class Xqwy_sfxmFrontController{

	@RequestMapping(value = "/beforePageList")
	public String beforeQueryList(Model model) {

		return "/xqwy/jbxx/sfxm/sfxmlist";
	}

	@RequestMapping(value = "/beforeAdd")
	public String beforeAdd(Model model) {
		return "/xqwy/jbxx/sfxm/add";
	}

	@RequestMapping(value = "/beforeEdit/{sfid}")
	public String beforeEdit(@PathVariable String sfid, Model model) {
		model.addAttribute("sfid", sfid);
		return "/xqwy/jbxx/sfxm/edit";
	}

	@RequestMapping(value = "/beforeView/{sfid}")
	public String beforeView(@PathVariable String sfid, Model model) {
		model.addAttribute("sfid", sfid);
		return "/xqwy/tccxx/sfxm/view";
	}

	

}

