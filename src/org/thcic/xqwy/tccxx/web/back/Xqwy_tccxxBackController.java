package org.thcic.xqwy.tccxx.web.back;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
import org.thcic.ejw.exception.GenericException;
import org.thcic.ejw.util.file.MyExcelUtil;
import org.thcic.xqwy.tccxx.dto.Xqwy_tccxxDto;
import org.thcic.xqwy.tccxx.qo.Xqwy_tccxxQo;
import org.thcic.xqwy.tccxx.service.Xqwy_tccxxService;
import org.thcic.xqwy.tccxx.vo.Xqwy_tccxx;

/**
 * 说明：增加，修改，删除教务办公发文表的前端处理类
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Controller
@RequestMapping("/xqwy/jbxx/tccxx")
public class Xqwy_tccxxBackController extends DataTableBackController<Xqwy_tccxx, Xqwy_tccxx>{

 
  
 	
  @Autowired
  private Xqwy_tccxxService xqwy_tccxxService; //逻辑层对象

  
	@RequestMapping(value = "/pageList")
	public @ResponseBody
	ControllerResult queryPageList(@RequestParam String aoData)
			throws Exception {
		return super.queryDataTablePageList(aoData);
	}

	@RequestMapping(value = "/add")
	public @ResponseBody
	ControllerResult add(@ModelAttribute Xqwy_tccxxDto dto) throws Exception {
		xqwy_tccxxService.add(dto);
		return ControllerResult.valueOf(ControllerResult.SUCCESS, "添加成功");
	}
	
	
	@RequestMapping(value = "/edit")
	public @ResponseBody
	ControllerResult edit(@ModelAttribute Xqwy_tccxxDto dto) throws Exception {
		xqwy_tccxxService.edit(dto);
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
@SuppressWarnings("unchecked")
@RequestMapping(value="/exportexcel")
public void exportExcel(HttpServletResponse response) throws Exception{
	Map<String, String> map=new LinkedHashMap<String,String>();
	map.put("xqmc", "小区名称");
	map.put("tccmc", "停车场名称");
	map.put("cwh", "车位号");
	Xqwy_tccxxQo qo=new Xqwy_tccxxQo();
	List<Xqwy_tccxxDto> list=(List<Xqwy_tccxxDto>) xqwy_tccxxService.queryList(qo);
	if(list==null||list.size()==0){
		throw new GenericException("没有数据");
	}
	MyExcelUtil.export(list, response, map, "停车场信息.xls");
}
	@Override
	protected BaseService<Xqwy_tccxx, Xqwy_tccxx> getService() {
		// TODO Auto-generated method stub
		return xqwy_tccxxService;
	}

	@Override
	protected Class<? extends DataTableQo> getQoClass() {
		// TODO Auto-generated method stub
		return Xqwy_tccxxQo.class;
	}
	

	

}

