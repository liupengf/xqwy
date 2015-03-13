package org.thcic.xqwy.gl.web.back;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thcic.ejw.components.datatable.DataTableBackController;
import org.thcic.ejw.components.datatable.DataTableQo;
import org.thcic.ejw.core.ro.ControllerResult;
import org.thcic.ejw.core.service.BaseService;
import org.thcic.xqwy.gl.service.Xqwy_bxService;
import org.thcic.xqwy.gl.dto.Xqwy_bxDto;
import org.thcic.xqwy.gl.qo.Xqwy_bxQo;
import org.thcic.xqwy.gl.vo.Xqwy_bx;


/**
 * 说明：增加，修改，删除xqwy_bx的前端处理类
 * 
 * @author liupengfei
 * @since 2015-03-10
 * @version 1.0
 */
@Controller
@RequestMapping("/xqwy/gl/bx")
public class Xqwy_bxBackController extends DataTableBackController<Xqwy_bx, Xqwy_bx>{
  
 	
  @Autowired
  private Xqwy_bxService xqwy_bxService; //逻辑层对象

  
	@RequestMapping(value = "/pageList")
	public @ResponseBody
	ControllerResult queryPageList(@RequestParam String aoData)
			throws Exception {
		return super.queryDataTablePageList(aoData);
	}

	@RequestMapping(value = "/add")
	public @ResponseBody
	ControllerResult add(@ModelAttribute Xqwy_bxDto dto) throws Exception {
		xqwy_bxService.add(dto);
		return ControllerResult.valueOf(ControllerResult.SUCCESS, "添加成功");
	}
	
	
	@RequestMapping(value = "/edit")
	public @ResponseBody
	ControllerResult edit(@ModelAttribute Xqwy_bxDto dto) throws Exception {
		xqwy_bxService.edit(dto);
		return ControllerResult.valueOf(ControllerResult.SUCCESS, "修改成功");
	}
	
	@RequestMapping(value = "/delete/{p_id}")
	public @ResponseBody
	ControllerResult delete(@PathVariable int p_id) throws Exception {
		return super.del(p_id);
	}
	
	
	@RequestMapping(value = "/detail/{p_id}")
	public @ResponseBody
	ControllerResult detail(@PathVariable int p_id) throws Exception {
		return super.queryById(p_id);
	}
   
	@Override
	protected BaseService<Xqwy_bx, Xqwy_bx> getService() {
		// TODO Auto-generated method stub
		return xqwy_bxService;
	}

	@Override
	protected Class<? extends DataTableQo> getQoClass() {
		// TODO Auto-generated method stub
		return Xqwy_bxQo.class;
	}
	

	

}

