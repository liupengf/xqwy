package org.thcic.xqwy.zhxx.vo;
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
@Table(name = "xqwy_zhxx")
public class Xqwy_zhxx implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2365492543082918350L;
	@Id

@Column(name = "sfz")
private String sfz;//主键id
	@Column(name="xqmc")
private String xqmc;//小区名称
	@Column(name="xm")
private String xm;//停车场名称
	@Column(name="address")
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



}
