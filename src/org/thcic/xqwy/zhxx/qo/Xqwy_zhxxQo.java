package org.thcic.xqwy.zhxx.qo;

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

public class Xqwy_zhxxQo extends DataTableQo {

	@QoField(operator = OperatorType.EQ)
	private String  sfz;//主键id
	@QoField(operator = OperatorType.LIKE)
	private String xqmc;//小区名称
	@QoField(operator = OperatorType.LIKE)
	private String xm;//停车场名称
	@QoField(operator = OperatorType.LIKE)
	private String address;//车位号
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

	/** 以下为get,set方法 */


}
