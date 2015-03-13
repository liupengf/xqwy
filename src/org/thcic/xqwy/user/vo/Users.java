package org.thcic.xqwy.user.vo;
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
@Table(name = "xqwy_users")
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3929323906703152026L;
	@Id
@Column(name = "username")
private String username;//主键id
	@Column(name="pwd")
private String pwd;//小区名称
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



}
