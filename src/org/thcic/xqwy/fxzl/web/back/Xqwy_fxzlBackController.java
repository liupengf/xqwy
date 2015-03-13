package org.thcic.xqwy.fxzl.web.back;
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
import org.thcic.xqwy.fxzl.dto.Xqwy_fxzlDto;
import org.thcic.xqwy.fxzl.qo.Xqwy_fxzlQo;
import org.thcic.xqwy.fxzl.service.Xqwy_fxzlService;
import org.thcic.xqwy.fxzl.vo.Xqwy_fxzl;

/**
 * 说明：增加，修改，删除教务办公发文表的前端处理类
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Controller
@RequestMapping("/xqwy/jbxx/fxzl")
public class Xqwy_fxzlBackController extends DataTableBackController<Xqwy_fxzl, Xqwy_fxzl>{

 
  
 	
  @Autowired
  private Xqwy_fxzlService xqwy_fxzlService; //逻辑层对象

  
	@RequestMapping(value = "/pageList")
	public @ResponseBody
	ControllerResult queryPageList(@RequestParam String aoData)
			throws Exception {
		return super.queryDataTablePageList(aoData);
	}

	@RequestMapping(value = "/add")
	public @ResponseBody
	ControllerResult add(@ModelAttribute Xqwy_fxzlDto dto) throws Exception {
		xqwy_fxzlService.add(dto);
		return ControllerResult.valueOf(ControllerResult.SUCCESS, "添加成功");
	}
	
	
	@RequestMapping(value = "/edit")
	public @ResponseBody
	ControllerResult edit(@ModelAttribute Xqwy_fxzlDto dto) throws Exception {
		xqwy_fxzlService.edit(dto);
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
    	 map.put("lpbh", "楼盘编号");
    	 map.put("fwbh", "房屋编号");
    	map.put("xqmc", "小区名称");
    	map.put("szlc", "所在楼层");
    	map.put("hx", "户型");
    	map.put("jzmj", "建筑面积");
    	map.put("symj", "使用面积");
    	 Xqwy_fxzlQo qo=new Xqwy_fxzlQo();
    	 List<Xqwy_fxzlDto> list=(List<Xqwy_fxzlDto>) xqwy_fxzlService.queryList(qo);
    	 if(list==null||list.size()==0){
    			throw new GenericException("没有数据");
    		}
    	 MyExcelUtil.export(list, response, map, "房型资料.xls");
     }
	@Override
	protected BaseService<Xqwy_fxzl, Xqwy_fxzl> getService() {
		// TODO Auto-generated method stub
		return xqwy_fxzlService;
	}

	@Override
	protected Class<? extends DataTableQo> getQoClass() {
		// TODO Auto-generated method stub
		return Xqwy_fxzlQo.class;
	}
	

	

}

