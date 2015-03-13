package org.thcic.xqwy.tccxx.vo;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 说明： 教务办公发文表 值对象类
 * 
 * @author liupengfei
 * @since 2015-03-06
 * @version 1.0
 */
@Entity
@Table(name = "xqwy_tccxx")
public class Xqwy_tccxx implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2081771075911885462L;
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "increment")
@Column(name = "xxid")
private int xxid;//主键id
	@Column(name="xqmc")
private String xqmc;//小区名称
	@Column(name="tccmc")
private String tccmc;//停车场名称
	@Column(name="cwh")
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



}
