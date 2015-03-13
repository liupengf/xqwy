package org.thcic.xqwy.gl.qo;
                import org.thcic.ejw.components.datatable.DataTableQo;
import org.thcic.ejw.core.qo.annotation.OperatorType;
import org.thcic.ejw.core.qo.annotation.QoClass;
import org.thcic.ejw.core.qo.annotation.QoField;


                            
/**
* 说明： xqwy_bx 值对象类
* 
* @author liupengfei
* @since 2015-03-10
* @version 1.0
*/
@QoClass
public class Xqwy_bxQo  extends DataTableQo{






@QoField(operator=OperatorType.EQ)
private int bxid; //bxid

@QoField(operator=OperatorType.LIKE)
private String bxr; //bxr


@QoField(operator=OperatorType.LIKE)
private String jzxq; //jzxq

@QoField(operator=OperatorType.LIKE)
private String bxlb; //bxlb

@QoField(operator=OperatorType.LIKE)
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
