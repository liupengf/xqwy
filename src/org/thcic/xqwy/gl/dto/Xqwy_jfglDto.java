package org.thcic.xqwy.gl.dto;
                                import java.io.Serializable;

import org.thcic.ejw.core.dto.Dto;


                                
/**
* 说明： xqwy_jfgl 值对象类
* 
* @author liupengfei
* @since 2015-03-10
* @version 1.0
*/

public class Xqwy_jfglDto  implements Dto{







/**
	 * 
	 */
	private static final long serialVersionUID = 1662316343362977990L;


private String sfz; //sfz


private String xm; //xm


private String xqmc; //xqmc


private String address; //address


private String sfmc; //sfmc


private String je; //je


private String yjje; //yjje


private String sfrq; //sfrq

private int jfid;



/** 以下为get,set方法 */
            public String getSfz() {
        return this.sfz;
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

        	
    
            public int getJfid() {
			return jfid;
		}
		public void setJfid(int jfid) {
			this.jfid = jfid;
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
		@Override
		public Serializable getId() {
			// TODO Auto-generated method stub
			return jfid;
		}

        	
    




}
