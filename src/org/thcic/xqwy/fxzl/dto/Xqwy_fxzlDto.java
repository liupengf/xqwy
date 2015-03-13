package org.thcic.xqwy.fxzl.dto;

import java.io.Serializable;

import org.thcic.ejw.core.dto.Dto;

/**
 * 说明： v_jwbg_fwb 值对象类
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */

public class Xqwy_fxzlDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 863032788602213995L;
	private int fxzlid ;
	private String lpbh ;//--楼盘编号---
	private String szlc;//#----所在楼层
	private String jzmj ;//----建筑面积
	private String symj ;//----使用面积
	private String hx;//------户型
	private String fwbh;//-----房屋编号
	private String xqmc;// ---小区名称


	public int getFxzlid() {
		return fxzlid;
	}


	public void setFxzlid(int fxzlid) {
		this.fxzlid = fxzlid;
	}


	public String getLpbh() {
		return lpbh;
	}


	public void setLpbh(String lpbh) {
		this.lpbh = lpbh;
	}


	public String getSzlc() {
		return szlc;
	}


	public void setSzlc(String szlc) {
		this.szlc = szlc;
	}


	public String getJzmj() {
		return jzmj;
	}


	public void setJzmj(String jzmj) {
		this.jzmj = jzmj;
	}


	public String getSymj() {
		return symj;
	}


	public void setSymj(String symj) {
		this.symj = symj;
	}


	public String getHx() {
		return hx;
	}


	public void setHx(String hx) {
		this.hx = hx;
	}


	public String getFwbh() {
		return fwbh;
	}


	public void setFwbh(String fwbh) {
		this.fwbh = fwbh;
	}


	public String getXqmc() {
		return xqmc;
	}


	public void setXqmc(String xqmc) {
		this.xqmc = xqmc;
	}


	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return fxzlid;
	}

	/** 以下为get,set方法 */

}
