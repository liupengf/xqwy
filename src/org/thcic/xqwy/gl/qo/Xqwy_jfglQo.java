package org.thcic.xqwy.gl.qo;
                                import org.thcic.ejw.components.datatable.DataTableQo;
import org.thcic.ejw.core.qo.annotation.OperatorType;
import org.thcic.ejw.core.qo.annotation.QoClass;
import org.thcic.ejw.core.qo.annotation.QoField;


                                
/**
* 说明： xqwy_jfgl 值对象类
* 
* @author liupengfei
* @since 2015-03-10
* @version 1.0
*/
@QoClass
public class Xqwy_jfglQo  extends DataTableQo{






@QoField(operator=OperatorType.LIKE)
private String sfz; //sfz

@QoField(operator=OperatorType.LIKE)
private String xm; //xm

@QoField(operator=OperatorType.LIKE)
private String xqmc; //xqmc

@QoField(operator=OperatorType.LIKE)
private String address; //address

@QoField(operator=OperatorType.LIKE)
private String sfmc; //sfmc

@QoField(operator=OperatorType.LIKE)
private String je; //je

@QoField(operator=OperatorType.LIKE)
private String yjje; //yjje

@QoField(operator=OperatorType.LIKE)
private String sfrq; //sfrq





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
