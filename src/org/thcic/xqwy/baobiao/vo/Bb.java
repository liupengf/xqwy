package org.thcic.xqwy.baobiao.vo;
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
@Table(name = "v_tjbb")
public class Bb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3421049270977874478L;
	@Id
@Column(name = "name")
private String name;//主键id
	@Id
	@Column(name="lb")
private String lb;//小区名称
	@Column(name="con")
	private int con;
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




}
