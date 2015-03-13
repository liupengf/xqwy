package org.thcic.xqwy.user.web.back;
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
import org.thcic.ejw.util.Md5;
import org.thcic.xqwy.user.dto.UsersDto;
import org.thcic.xqwy.user.qo.UsersQo;
import org.thcic.xqwy.user.service.UsersService;
import org.thcic.xqwy.user.vo.Users;

/**
 * 说明：增加，修改，删除教务办公发文表的前端处理类
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Controller
@RequestMapping("/xqwy/xtgl/user")
public class Xqwy_UserBackController extends DataTableBackController<Users, Users>{

 
  
 	
  @Autowired
  private UsersService usersService; //逻辑层对象

  
	@RequestMapping(value = "/pageList")
	public @ResponseBody
	ControllerResult queryPageList(@RequestParam String aoData)
			throws Exception {
		return super.queryDataTablePageList(aoData);
	}

	@RequestMapping(value = "/add")
	public @ResponseBody
	ControllerResult add(@ModelAttribute UsersDto dto) throws Exception {
		dto.setPwd(Md5.getMD5ofStr(dto.getPwd()));
		usersService.add(dto);
		return ControllerResult.valueOf(ControllerResult.SUCCESS, "添加成功");
	}
	
	
	@RequestMapping(value = "/edit")
	public @ResponseBody
	ControllerResult edit(@ModelAttribute UsersDto dto) throws Exception {
		UsersDto usersDto=(UsersDto) usersService.queryById(dto.getOldusername());
		if(dto.getUsername().equals(dto.getOldusername())){
			if(!usersDto.getPwd().equals(dto.getPwd())){
				dto.setPwd(Md5.getMD5ofStr(dto.getPwd()));
			}
		usersService.edit(dto);
		}else{
			usersService.del(dto.getOldusername());
			if(!usersDto.getPwd().equals(dto.getPwd())){
				dto.setPwd(Md5.getMD5ofStr(dto.getPwd()));
			}
			usersService.add(dto);
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

	@Override
	protected BaseService<Users, Users> getService() {
		// TODO Auto-generated method stub
		return usersService;
	}

	@Override
	protected Class<? extends DataTableQo> getQoClass() {
		// TODO Auto-generated method stub
		return UsersQo.class;
	}
	

	

}

