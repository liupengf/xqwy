package org.thcic.xqwy.sfxm.web.back;
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
import org.thcic.xqwy.sfxm.dto.Xqwy_sfxmDto;
import org.thcic.xqwy.sfxm.qo.Xqwy_sfxmQo;
import org.thcic.xqwy.sfxm.service.Xqwy_sfxmService;
import org.thcic.xqwy.sfxm.vo.Xqwy_sfxm;

/**
 * 说明：增加，修改，删除教务办公发文表的前端处理类
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Controller
@RequestMapping("/xqwy/jbxx/sfxm")
public class Xqwy_sfxmBackController extends DataTableBackController<Xqwy_sfxm, Xqwy_sfxm>{

 
  
 	
  @Autowired
  private Xqwy_sfxmService xqwy_sfxmService; //逻辑层对象

  
	@RequestMapping(value = "/pageList")
	public @ResponseBody
	ControllerResult queryPageList(@RequestParam String aoData)
			throws Exception {
		return super.queryDataTablePageList(aoData);
	}

	@RequestMapping(value = "/add")
	public @ResponseBody
	ControllerResult add(@ModelAttribute Xqwy_sfxmDto dto) throws Exception {
		xqwy_sfxmService.add(dto);
		return ControllerResult.valueOf(ControllerResult.SUCCESS, "添加成功");
	}
	
	
	@RequestMapping(value = "/edit")
	public @ResponseBody
	ControllerResult edit(@ModelAttribute Xqwy_sfxmDto dto) throws Exception {
		if(dto.getSfid().equals(dto.getYsfid())){
			xqwy_sfxmService.edit(dto);
		}else{
		xqwy_sfxmService.del(dto.getYsfid());
		xqwy_sfxmService.add(dto);
		}
		return ControllerResult.valueOf(ControllerResult.SUCCESS, "修改成功");
	}
	
	@RequestMapping(value = "/delete/{id}")
	public @ResponseBody
	ControllerResult delete(@PathVariable String id) throws Exception {
		return super.del(id);
	}
	
	
	@RequestMapping(value = "/detail/{p_id}")
	public @ResponseBody
	ControllerResult detail(@PathVariable String p_id) throws Exception {
		return super.queryById(p_id);
	}
  @SuppressWarnings("unchecked")
@RequestMapping(value="/exportexcel")
  public void exportExcel(HttpServletResponse response) throws Exception{
	  Map<String, String> map=new LinkedHashMap<String,String>();
	  map.put("sfid", "收费编号");
	  map.put("sfmc", "收费名称");
	  Xqwy_sfxmQo qo=new Xqwy_sfxmQo();
	  List<Xqwy_sfxmDto> list=(List<Xqwy_sfxmDto>) xqwy_sfxmService.queryList(qo);
	  if(list==null||list.size()==0){
			throw new GenericException("没有数据");
		}
	  MyExcelUtil.export(list, response, map, "收费项目.xls");
  }
	@Override
	protected BaseService<Xqwy_sfxm, Xqwy_sfxm> getService() {
		// TODO Auto-generated method stub
		return xqwy_sfxmService;
	}

	@Override
	protected Class<? extends DataTableQo> getQoClass() {
		// TODO Auto-generated method stub
		return Xqwy_sfxmQo.class;
	}
	

	

}

