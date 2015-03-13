package org.thcic.xqwy.gl.dto;
                    import java.io.Serializable;

import org.thcic.ejw.core.dto.Dto;


                        
/**
* 说明： xqwy_zhtcw 值对象类
* 
* @author liupengfei
* @since 2015-03-10
* @version 1.0
*/

public class Xqwy_zhtcwDto  implements Dto{






/**
	 * 
	 */
	private static final long serialVersionUID = 3622298031502992259L;


private String sfz; //sfz
private String ysfz; //sfz


private String xm; //xm


private String xqmc; //xqmc


private String tccmc; //tccmc


private String cwh; //cwh





/** 以下为get,set方法 */

            public String getSfz() {
        return this.sfz;
        }
        public String getYsfz() {
	return ysfz;
}
public void setYsfz(String ysfz) {
	this.ysfz = ysfz;
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
		@Override
		public Serializable getId() {
			// TODO Auto-generated method stub
			return sfz;
		}

        	
    




}
