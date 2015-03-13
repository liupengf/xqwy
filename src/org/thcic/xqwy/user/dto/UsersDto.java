package org.thcic.xqwy.user.dto;

import java.io.Serializable;

import org.thcic.ejw.core.dto.Dto;

/**
 * 说明： v_jwbg_fwb 值对象类
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */

public class UsersDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4393524268902782847L;
	private String username;// 停车场名称
	private String oldusername;// 停车场名称
	private String pwd;// 车位号


	public String getOldusername() {
		return oldusername;
	}


	public void setOldusername(String oldusername) {
		this.oldusername = oldusername;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return username;
	}

	/** 以下为get,set方法 */

}
