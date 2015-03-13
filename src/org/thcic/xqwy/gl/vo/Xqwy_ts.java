package org.thcic.xqwy.gl.vo;
                import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

                            
/**
* 说明： xqwy_ts 值对象类
* 
* @author liupengfei
* @since 2015-03-10
* @version 1.0
*/
@Entity
@Table(name = "XQWY_TS")
public class Xqwy_ts implements Serializable{






/**
	 * 
	 */
	private static final long serialVersionUID = 480376063551368753L;

@Id
@GeneratedValue(generator = "paymentableGenerator")
@GenericGenerator(name = "paymentableGenerator", strategy = "increment")
@Column(name="TSID")
private int tsid; //tsid

@Column(name="TSR")
private String tsr; //tsr

@Column(name="TSSJ")
private String tssj; //tssj

@Column(name="JZXQ")
private String jzxq; //jzxq

@Column(name="TSLB")
private String tslb; //tslb

@Column(name="TSNR")
private String tsnr; //tsnr





/** 以下为get,set方法 */
   
            public String getTsr() {
        return this.tsr;
        }
        public int getTsid() {
	return tsid;
}
public void setTsid(int tsid) {
	this.tsid = tsid;
}
		public void setTsr(String tsr) {
        this.tsr = tsr;
        }

  
    
            public String getTssj() {
			return tssj;
		}
		public void setTssj(String tssj) {
			this.tssj = tssj;
		}
			public String getJzxq() {
        return this.jzxq;
        }
        public void setJzxq(String jzxq) {
        this.jzxq = jzxq;
        }

        	
    
            public String getTslb() {
        return this.tslb;
        }
        public void setTslb(String tslb) {
        this.tslb = tslb;
        }

        	
    
            public String getTsnr() {
        return this.tsnr;
        }
        public void setTsnr(String tsnr) {
        this.tsnr = tsnr;
        }

        	
    




}
