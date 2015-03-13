package org.thcic.xqwy.gl.dto;
                    import java.io.Serializable;

import org.thcic.ejw.core.dto.Dto;


                            
/**
* 说明： xqwy_bx 值对象类
* 
* @author liupengfei
* @since 2015-03-10
* @version 1.0
*/

public class Xqwy_bxDto  implements Dto{






/**
	 * 
	 */
	private static final long serialVersionUID = -3505375527647924533L;


private int bxid; //bxid


private String bxr; //bxr


private String bxsj; //bxsj


private String jzxq; //jzxq


private String bxlb; //bxlb


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
		@Override
		public Serializable getId() {
			// TODO Auto-generated method stub
			return bxid;
		}

        	
    




}
