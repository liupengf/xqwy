package org.thcic.xqwy.user.qo;

import org.thcic.ejw.components.datatable.DataTableQo;
import org.thcic.ejw.core.qo.annotation.OperatorType;
import org.thcic.ejw.core.qo.annotation.QoField;

/**
 * 说明： v_jwbg_fwb 值对象类
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */

public class UsersQo extends DataTableQo {

	@QoField(operator = OperatorType.LIKE)
	private String username;//小区名称

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	/** 以下为get,set方法 */


}
