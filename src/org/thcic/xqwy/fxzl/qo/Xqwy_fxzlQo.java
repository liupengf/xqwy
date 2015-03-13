package org.thcic.xqwy.fxzl.qo;

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

public class Xqwy_fxzlQo extends DataTableQo {

	@QoField(operator = OperatorType.EQ)
	private int fxzlid ;
	@QoField(operator = OperatorType.EQ)
	private String lpbh ;//--楼盘编号---
	@QoField(operator = OperatorType.EQ)
	private String szlc;//#----所在楼层
	@QoField(operator = OperatorType.EQ)
	private String jzmj ;//----建筑面积
	@QoField(operator = OperatorType.EQ)
	private String symj ;//----使用面积
	@QoField(operator = OperatorType.LIKE)
	private String hx;//------户型
	@QoField(operator = OperatorType.EQ)
	private String fwbh;//-----房屋编号
	@QoField(operator = OperatorType.LIKE)
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
	
	/** 以下为get,set方法 */


}
