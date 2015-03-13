package org.thcic.xqwy.gl.vo;
                    import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


                        
/**
* 说明： xqwy_zhtcw 值对象类
* 
* @author liupengfei
* @since 2015-03-10
* @version 1.0
*/
@Entity
@Table(name = "XQWY_ZHTCW")
public class Xqwy_zhtcw implements Serializable{






/**
	 * 
	 */
	private static final long serialVersionUID = 4064537417874252838L;

@Id
@Column(name="SFZ")
private String sfz; //sfz

@Column(name="XM")
private String xm; //xm

@Column(name="XQMC")
private String xqmc; //xqmc

@Column(name="TCCMC")
private String tccmc; //tccmc

@Column(name="CWH")
private String cwh; //cwh





/** 以下为get,set方法 */
            public String getSfz() {
        return this.sfz;
        }
        public void setSfz(String sfz) {
        this.sfz = sfz;
        }

        	
    
            public String getId() {
            return this.sfz;
            }
            public void setId(String sfz) {
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

        	
    
            public String getTccmc() {
        return this.tccmc;
        }
        public void setTccmc(String tccmc) {
        this.tccmc = tccmc;
        }

        	
    
            public String getCwh() {
        return this.cwh;
        }
        public void setCwh(String cwh) {
        this.cwh = cwh;
        }

        	
    




}
