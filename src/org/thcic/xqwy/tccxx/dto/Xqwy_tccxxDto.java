package org.thcic.xqwy.tccxx.dto;

import java.io.Serializable;

import org.thcic.ejw.core.dto.Dto;

/**
 * 说明： v_jwbg_fwb 值对象类
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */

public class Xqwy_tccxxDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4124891360402392851L;
	private int xxid;// 主键id
	private String xqmc;// 小区名称
	private String tccmc;// 停车场名称
	private String cwh;// 车位号

	public int getXxid() {
		return xxid;
	}

	public void setXxid(int xxid) {
		this.xxid = xxid;
	}

	public String getXqmc() {
		return xqmc;
	}

	public void setXqmc(String xqmc) {
		this.xqmc = xqmc;
	}

	public String getTccmc() {
		return tccmc;
	}

	public void setTccmc(String tccmc) {
		this.tccmc = tccmc;
	}

	public String getCwh() {
		return cwh;
	}

	public void setCwh(String cwh) {
		this.cwh = cwh;
	}

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return xxid;
	}

	/** 以下为get,set方法 */

}
