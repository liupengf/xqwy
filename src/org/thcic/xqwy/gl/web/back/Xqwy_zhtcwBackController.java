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
import org.thcic.xqwy.gl.service.Xqwy_zhtcwService;
import org.thcic.xqwy.gl.dto.Xqwy_zhtcwDto;
import org.thcic.xqwy.gl.qo.Xqwy_zhtcwQo;
import org.thcic.xqwy.gl.vo.Xqwy_zhtcw;


/**
 * 说明：增加，修改，删除xqwy_zhtcw的前端处理类
 * 
 * @author liupengfei
 * @since 2015-03-10
 * @version 1.0
 */
@Controller
@RequestMapping("/xqwy/gl/zhtcw")
public class Xqwy_zhtcwBackController extends DataTableBackController<Xqwy_zhtcw, Xqwy_zhtcw>{
  
 	
  @Autowired
  private Xqwy_zhtcwService xqwy_zhtcwService; //逻辑层对象

  
	@RequestMapping(value = "/pageList")
	public @ResponseBody
	ControllerResult queryPageList(@RequestParam String aoData)
			throws Exception {
		return super.queryDataTablePageList(aoData);
	}

	@RequestMapping(value = "/add")
	public @ResponseBody
	ControllerResult add(@ModelAttribute Xqwy_zhtcwDto dto) throws Exception {
		xqwy_zhtcwService.add(dto);
		return ControllerResult.valueOf(ControllerResult.SUCCESS, "添加成功");
	}
	
	
	@RequestMapping(value = "/edit")
	public @ResponseBody
	ControllerResult edit(@ModelAttribute Xqwy_zhtcwDto dto) throws Exception {
		if(dto.getSfz().equals(dto.getYsfz())){
			xqwy_zhtcwService.edit(dto);
		}else{
		xqwy_zhtcwService.del(dto.getYsfz());
		xqwy_zhtcwService.add(dto);
		}
		return ControllerResult.valueOf(ControllerResult.SUCCESS, "修改成功");
	}
	
	@RequestMapping(value = "/delete/{p_id}")
	public @ResponseBody
	ControllerResult delete(@PathVariable String p_id) throws Exception {
		return super.del(p_id);
	}
	
	
	@RequestMapping(value = "/detail/{p_id}")
	public @ResponseBody
	ControllerResult detail(@PathVariable String p_id) throws Exception {
		return super.queryById(p_id);
	}

	@Override
	protected BaseService<Xqwy_zhtcw, Xqwy_zhtcw> getService() {
		// TODO Auto-generated method stub
		return xqwy_zhtcwService;
	}

	@Override
	protected Class<? extends DataTableQo> getQoClass() {
		// TODO Auto-generated method stub
		return Xqwy_zhtcwQo.class;
	}
	

	

}

