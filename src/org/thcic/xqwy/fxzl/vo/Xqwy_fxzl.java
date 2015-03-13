package org.thcic.xqwy.fxzl.vo;
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
@Table(name = "xqwy_fxzl")
public class Xqwy_fxzl implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 992732338379713894L;
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "increment")
	@Column(name="fxzlid")
	private int fxzlid ;
	@Column(name="lpbh")
	private String lpbh ;//--楼盘编号---
	@Column(name="szlc")
	private String szlc;//#----所在楼层
	@Column(name="jzmj")
	private String jzmj ;//----建筑面积
	@Column(name="symj")
	private String symj ;//----使用面积
	@Column(name="hx")
	private String hx;//------户型
	@Column(name="fwbh")
	private String fwbh;//-----房屋编号
	@Column(name="xqmc")
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



}
