package org.thcic.xqwy.gl.dto;
                    import java.io.Serializable;

import org.thcic.ejw.core.dto.Dto;


                            
/**
* 说明： xqwy_ts 值对象类
* 
* @author liupengfei
* @since 2015-03-10
* @version 1.0
*/

public class Xqwy_tsDto  implements Dto{






/**
	 * 
	 */
	private static final long serialVersionUID = -86395242895576431L;


private int tsid; //tsid


private String tsr; //tsr


private String tssj; //tssj


private String jzxq; //jzxq


private String tslb; //tslb


private String tsnr; //tsnr





/** 以下为get,set方法 */
   
            public String getTsr() {
        return this.tsr;
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
		public int getTsid() {
			return tsid;
		}
		public void setTsid(int tsid) {
			this.tsid = tsid;
		}
		@Override
		public Serializable getId() {
			// TODO Auto-generated method stub
			return tsid;
		}

        	
    




}
