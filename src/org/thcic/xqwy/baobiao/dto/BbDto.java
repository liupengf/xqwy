package org.thcic.xqwy.baobiao.dto;

import java.io.Serializable;

import org.thcic.ejw.core.dto.Dto;

/**
 * 说明： v_jwbg_fwb 值对象类
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */

public class BbDto implements Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2397953103020749079L;
	private String name;// 停车场名称
	private String lb;// 停车场名称
	private int con;// 车位号




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getLb() {
		return lb;
	}




	public void setLb(String lb) {
		this.lb = lb;
	}




	public int getCon() {
		return con;
	}




	public void setCon(int con) {
		this.con = con;
	}




	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return name;
	}

	/** 以下为get,set方法 */

}
