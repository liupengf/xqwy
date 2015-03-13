package org.thcic.xqwy.zhxx.web.back;
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
import org.thcic.xqwy.zhxx.dto.Xqwy_zhxxDto;
import org.thcic.xqwy.zhxx.qo.Xqwy_zhxxQo;
import org.thcic.xqwy.zhxx.service.Xqwy_zhxxService;
import org.thcic.xqwy.zhxx.vo.Xqwy_zhxx;

/**
 * 说明：增加，修改，删除教务办公发文表的前端处理类
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Controller
@RequestMapping("/xqwy/jbxx/zhxx")
public class Xqwy_zhxxBackController extends DataTableBackController<Xqwy_zhxx, Xqwy_zhxx>{

 
  
 	
  @Autowired
  private Xqwy_zhxxService xqwy_zhxxService; //逻辑层对象

  
	@RequestMapping(value = "/pageList")
	public @ResponseBody
	ControllerResult queryPageList(@RequestParam String aoData)
			throws Exception {
		return super.queryDataTablePageList(aoData);
	}

	@RequestMapping(value = "/add")
	public @ResponseBody
	ControllerResult add(@ModelAttribute Xqwy_zhxxDto dto) throws Exception {
		xqwy_zhxxService.add(dto);
		return ControllerResult.valueOf(ControllerResult.SUCCESS, "添加成功");
	}
	
	
	@RequestMapping(value = "/edit")
	public @ResponseBody
	ControllerResult edit(@ModelAttribute Xqwy_zhxxDto dto) throws Exception {
		if(dto.getSfz().equals(dto.getYsfz())){
			xqwy_zhxxService.edit(dto);
		}else{
		xqwy_zhxxService.del(dto.getYsfz());
		xqwy_zhxxService.add(dto);
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
		map.put("sfz", "身份证");
		map.put("xm", "姓名");
		map.put("xqmc", "小区名称");
		map.put("address", "住址");
		Xqwy_zhxxQo qo=new Xqwy_zhxxQo();
		List<Xqwy_zhxxDto> list=(List<Xqwy_zhxxDto>) xqwy_zhxxService.queryList(qo);
		if(list==null||list.size()==0){
			throw new GenericException("没有数据");
		}
    	MyExcelUtil.export(list, response, map, "住户信息.xls");
    
    }
	@Override
	protected BaseService<Xqwy_zhxx, Xqwy_zhxx> getService() {
		// TODO Auto-generated method stub
		return xqwy_zhxxService;
	}

	@Override
	protected Class<? extends DataTableQo> getQoClass() {
		// TODO Auto-generated method stub
		return Xqwy_zhxxQo.class;
	}
	

	

}

