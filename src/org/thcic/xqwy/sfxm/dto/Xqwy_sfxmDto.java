package org.thcic.xqwy.sfxm.dto;

import java.io.Serializable;

import org.thcic.ejw.core.dto.Dto;

/**
 * 说明： v_jwbg_fwb 值对象类
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */

public class Xqwy_sfxmDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6957370966202522249L;
	private String ysfid;// 主键id
	private String sfid;// 主键id
	private String sfmc;// 收费名称



	public String getYsfid() {
		return ysfid;
	}



	public void setYsfid(String ysfid) {
		this.ysfid = ysfid;
	}



	public String getSfid() {
		return sfid;
	}



	public void setSfid(String sfid) {
		this.sfid = sfid;
	}






	public String getSfmc() {
		return sfmc;
	}



	public void setSfmc(String sfmc) {
		this.sfmc = sfmc;
	}



	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return sfid;
	}

	/** 以下为get,set方法 */

}
