package org.thcic.xqwy.baobiao.web.back;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thcic.ejw.components.datatable.DataTableBackController;
import org.thcic.ejw.components.datatable.DataTableQo;
import org.thcic.ejw.core.ro.ControllerResult;
import org.thcic.ejw.core.service.BaseService;
import org.thcic.xqwy.baobiao.qo.BbQo;
import org.thcic.xqwy.baobiao.service.BbService;
import org.thcic.xqwy.baobiao.vo.Bb;

/**
 * 说明：增加，修改，删除教务办公发文表的前端处理类
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Controller
@RequestMapping("/xqwy/bb/xtbb")
public class Xqwy_BbBackController extends DataTableBackController<Bb, Bb>{

 
  
 	
  @Autowired
  private BbService bbService; //逻辑层对象

  
	@RequestMapping(value = "/pageList")
	public @ResponseBody
	ControllerResult queryPageList()
			throws Exception {
		return ControllerResult.valueOf(ControllerResult.SUCCESS,bbService.getAllBb());
	}

	@Override
	protected BaseService<Bb, Bb> getService() {
		// TODO Auto-generated method stub
		return bbService;
	}

	@Override
	protected Class<? extends DataTableQo> getQoClass() {
		// TODO Auto-generated method stub
		return BbQo.class;
	}
	

	

}

