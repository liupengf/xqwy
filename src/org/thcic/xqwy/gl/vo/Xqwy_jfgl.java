package org.thcic.xqwy.gl.vo;
                                import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


                                
/**
* 说明： xqwy_jfgl 值对象类
* 
* @author liupengfei
* @since 2015-03-10
* @version 1.0
*/
@Entity
@Table(name = "XQWY_JFGL")
public class Xqwy_jfgl implements Serializable{





/**
	 * 
	 */
	private static final long serialVersionUID = -7249327199695106371L;
	@Id
@GeneratedValue(generator = "paymentableGenerator")
@GenericGenerator(name = "paymentableGenerator", strategy = "increment")
@Column(name="jfid")
private int jfid;
@Column(name="SFZ")
private String sfz; //sfz

@Column(name="XM")
private String xm; //xm

@Column(name="XQMC")
private String xqmc; //xqmc

@Column(name="ADDRESS")
private String address; //address

@Column(name="SFMC")
private String sfmc; //sfmc

@Column(name="JE")
private String je; //je

@Column(name="YJJE")
private String yjje; //yjje

@Column(name="SFRQ")
private String sfrq; //sfrq





/** 以下为get,set方法 */

            public String getSfz() {
        return this.sfz;
        }
        public int getJfid() {
	return jfid;
}
public void setJfid(int jfid) {
	this.jfid = jfid;
}
		public void setSfz(String sfz) {
        this.sfz = sfz;
        }

        	
    
            public String getXm() {
        return this.xm;
        }
        public void setXm(String xm) {
        this.xm = xm;
        }

        	
    
            public String getXqmc() {
        return this.xqmc;
        }
        public void setXqmc(String xqmc) {
        this.xqmc = xqmc;
        }

        	
    
            public String getAddress() {
        return this.address;
        }
        public void setAddress(String address) {
        this.address = address;
        }

        	
    
            public String getSfmc() {
        return this.sfmc;
        }
        public void setSfmc(String sfmc) {
        this.sfmc = sfmc;
        }

        	
    
            public String getJe() {
        return this.je;
        }
        public void setJe(String je) {
        this.je = je;
        }

        	
    
            public String getYjje() {
        return this.yjje;
        }
        public void setYjje(String yjje) {
        this.yjje = yjje;
        }

        	
    
            public String getSfrq() {
        return this.sfrq;
        }
        public void setSfrq(String sfrq) {
        this.sfrq = sfrq;
        }

        	
    




}
