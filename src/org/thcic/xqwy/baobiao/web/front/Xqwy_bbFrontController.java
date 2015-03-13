package org.thcic.xqwy.baobiao.web.front;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 说明：增加，修改，删除教务办公发文表的前端处理类
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Controller
@RequestMapping("/xqwy/bb/xtbb")
public class Xqwy_bbFrontController{

	@RequestMapping(value = "/beforeBb")
	public String beforeQueryList(Model model) {

		return "/xqwy/bb/xtbb";
	}

	

}

