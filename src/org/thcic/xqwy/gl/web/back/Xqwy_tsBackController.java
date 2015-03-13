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
import org.thcic.xqwy.gl.service.Xqwy_tsService;
import org.thcic.xqwy.gl.dto.Xqwy_tsDto;
import org.thcic.xqwy.gl.qo.Xqwy_tsQo;
import org.thcic.xqwy.gl.vo.Xqwy_ts;


/**
 * 说明：增加，修改，删除xqwy_ts的前端处理类
 * 
 * @author liupengfei
 * @since 2015-03-10
 * @version 1.0
 */
@Controller
@RequestMapping("/xqwy/gl/ts")
public class Xqwy_tsBackController extends DataTableBackController<Xqwy_ts, Xqwy_ts>{

  
 	
  @Autowired
  private Xqwy_tsService xqwy_tsService; //逻辑层对象

  
	@RequestMapping(value = "/pageList")
	public @ResponseBody
	ControllerResult queryPageList(@RequestParam String aoData)
			throws Exception {
		return super.queryDataTablePageList(aoData);
	}

	@RequestMapping(value = "/add")
	public @ResponseBody
	ControllerResult add(@ModelAttribute Xqwy_tsDto dto) throws Exception {
		xqwy_tsService.add(dto);
		return ControllerResult.valueOf(ControllerResult.SUCCESS, "添加成功");
	}
	
	
	@RequestMapping(value = "/edit")
	public @ResponseBody
	ControllerResult edit(@ModelAttribute Xqwy_tsDto dto) throws Exception {
		xqwy_tsService.edit(dto);
		return ControllerResult.valueOf(ControllerResult.SUCCESS, "修改成功");
	}
	
	@RequestMapping(value = "/delete/{id}")
	public @ResponseBody
	ControllerResult delete(@PathVariable int id) throws Exception {
		return super.del(id);
	}
	
	
	@RequestMapping(value = "/detail/{p_id}")
	public @ResponseBody
	ControllerResult detail(@PathVariable int p_id) throws Exception {
		return super.queryById(p_id);
	}

	@Override
	protected BaseService<Xqwy_ts, Xqwy_ts> getService() {
		// TODO Auto-generated method stub
		return xqwy_tsService;
	}

	@Override
	protected Class<? extends DataTableQo> getQoClass() {
		// TODO Auto-generated method stub
		return Xqwy_tsQo.class;
	}
	

	

}

