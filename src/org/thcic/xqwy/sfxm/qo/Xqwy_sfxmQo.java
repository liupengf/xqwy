package org.thcic.xqwy.sfxm.qo;

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

public class Xqwy_sfxmQo extends DataTableQo {

	@QoField(operator = OperatorType.EQ)
	private String sfid;//主键id
	@QoField(operator = OperatorType.LIKE)
	private String sfmc;//收费名称
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


	/** 以下为get,set方法 */


}
