package org.thcic.xqwy.sfxm.vo;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 说明： 教务办公发文表 值对象类
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Entity
@Table(name = "xqwy_sfxm")
public class Xqwy_sfxm implements Serializable {

	
/**
	 * 
	 */
	private static final long serialVersionUID = -2261621409564986004L;
	@Id
@Column(name = "sfid")
private String sfid;//主键id
	@Column(name="sfmc")
private String sfmc;//小区名称
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


}
