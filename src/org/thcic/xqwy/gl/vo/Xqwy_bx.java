package org.thcic.xqwy.gl.vo;
                import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

                            
/**
* 说明： xqwy_bx 值对象类
* 
* @author liupengfei
* @since 2015-03-10
* @version 1.0
*/
@Entity
@Table(name = "XQWY_BX")
public class Xqwy_bx implements Serializable{






/**
	 * 
	 */
	private static final long serialVersionUID = -2748242146943721003L;

@Id
@GeneratedValue(generator = "paymentableGenerator")
@GenericGenerator(name = "paymentableGenerator", strategy = "increment")
@Column(name="BXID")
private int bxid; //bxid

@Column(name="BXR")
private String bxr; //bxr

@Column(name="BXSJ")
private String bxsj; //bxsj

@Column(name="JZXQ")
private String jzxq; //jzxq

@Column(name="BXLB")
private String bxlb; //bxlb

@Column(name="BXNR")
private String bxnr; //bxnr





/** 以下为get,set方法 */
      
            public String getBxr() {
        return this.bxr;
        }
        public int getBxid() {
	return bxid;
}
public void setBxid(int bxid) {
	this.bxid = bxid;
}
		public void setBxr(String bxr) {
        this.bxr = bxr;
        }

        	
  
        	
    
            public String getBxsj() {
			return bxsj;
		}
		public void setBxsj(String bxsj) {
			this.bxsj = bxsj;
		}
			public String getJzxq() {
        return this.jzxq;
        }
        public void setJzxq(String jzxq) {
        this.jzxq = jzxq;
        }

        	
    
            public String getBxlb() {
        return this.bxlb;
        }
        public void setBxlb(String bxlb) {
        this.bxlb = bxlb;
        }

        	
    
            public String getBxnr() {
        return this.bxnr;
        }
        public void setBxnr(String bxnr) {
        this.bxnr = bxnr;
        }

        	
    




}
