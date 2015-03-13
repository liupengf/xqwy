package org.thcic.xqwy.gl.qo;
                    import org.thcic.ejw.components.datatable.DataTableQo;
import org.thcic.ejw.core.qo.annotation.OperatorType;
import org.thcic.ejw.core.qo.annotation.QoClass;
import org.thcic.ejw.core.qo.annotation.QoField;


                        
/**
* 说明： xqwy_zhtcw 值对象类
* 
* @author liupengfei
* @since 2015-03-10
* @version 1.0
*/
@QoClass
public class Xqwy_zhtcwQo  extends DataTableQo{






@QoField(operator=OperatorType.EQ)
private String sfz; //sfz

@QoField(operator=OperatorType.LIKE)
private String xm; //xm

@QoField(operator=OperatorType.LIKE)
private String xqmc; //xqmc

@QoField(operator=OperatorType.LIKE)
private String tccmc; //tccmc

@QoField(operator=OperatorType.LIKE)
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
