package org.thcic.xqwy.gl.qo;
                import org.thcic.ejw.components.datatable.DataTableQo;
import org.thcic.ejw.core.qo.annotation.OperatorType;
import org.thcic.ejw.core.qo.annotation.QoClass;
import org.thcic.ejw.core.qo.annotation.QoField;


                            
/**
* 说明： xqwy_ts 值对象类
* 
* @author liupengfei
* @since 2015-03-10
* @version 1.0
*/
@QoClass
public class Xqwy_tsQo  extends DataTableQo{






@QoField(operator=OperatorType.EQ)
private int tsid; //tsid

@QoField(operator=OperatorType.LIKE)
private String tsr; //tsr
@QoField(operator=OperatorType.LIKE)
private String jzxq; //jzxq

@QoField(operator=OperatorType.LIKE)
private String tslb; //tslb

@QoField(operator=OperatorType.LIKE)
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
