package org.thcic.xqwy.zhxx.dto;

import java.io.Serializable;

import org.thcic.ejw.core.dto.Dto;

/**
 * 说明： v_jwbg_fwb 值对象类
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */

public class Xqwy_zhxxDto implements Dto {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7829035367929982149L;
	private String sfz;// 主键id
	private String ysfz;// 主键id
	private String xqmc;// 小区名称
	private String xm;// 停车场名称
	private String address;// 车位号

	public String getYsfz() {
		return ysfz;
	}

	public void setYsfz(String ysfz) {
		this.ysfz = ysfz;
	}

	public String getSfz() {
		return sfz;
	}

	public void setSfz(String sfz) {
		this.sfz = sfz;
	}

	public String getXqmc() {
		return xqmc;
	}

	public void setXqmc(String xqmc) {
		this.xqmc = xqmc;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return sfz;
	}

	/** 以下为get,set方法 */

}
