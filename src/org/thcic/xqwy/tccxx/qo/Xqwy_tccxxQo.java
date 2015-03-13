package org.thcic.xqwy.tccxx.qo;

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

public class Xqwy_tccxxQo extends DataTableQo {

	@QoField(operator = OperatorType.EQ)
	private int xxid;//主键id
	@QoField(operator = OperatorType.LIKE)
	private String xqmc;//小区名称
	@QoField(operator = OperatorType.LIKE)
	private String tccmc;//停车场名称
	@QoField(operator = OperatorType.EQ)
	private String cwh;//车位号
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

	/** 以下为get,set方法 */


}
