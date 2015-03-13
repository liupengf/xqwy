package org.thcic.ejw.util.file;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.util.StringUtils;
import org.thcic.ejw.exception.GenericException;
public class MyExcelUtil {
public  static <E> void  export(List<E>list,HttpServletResponse response,Map<String, String> map,String fileName) throws Exception{
	response.reset();
	response.setContentType("application/vnd.ms-excel");
	if (!StringUtils.hasText(fileName)) {
		fileName = "无标题.xls";
	}
	response.setHeader("Content-disposition", "attachment; filename="
			+ new String(fileName.getBytes(), "ISO-8859-1"));
	listToExcel(list, map, 65535,fileName,  response.getOutputStream());
}
public static <T>  void   listToExcel ( List<T> list , Map<String,String> fieldMap, int sheetSize,  String sheetName, OutputStream out ) throws Exception{ 
       
       
    if(list.size()==0 || list==null){ 
        throw new GenericException("数据源中没有任何数据"); 
    } 
       
    if(sheetSize>65535 || sheetSize<1){ 
        sheetSize=65535; 
    } 
       
    //创建工作簿并发送到OutputStream指定的地方 
    WritableWorkbook wwb; 
    try { 
        wwb = Workbook.createWorkbook(out); 
           
        //因为2003的Excel一个工作表最多可以有65536条记录，除去列头剩下65535条 
        //所以如果记录太多，需要放到多个工作表中，其实就是个分页的过程 
        //1.计算一共有多少个工作表 
        double sheetNum=Math.ceil(list.size()/new Integer(sheetSize).doubleValue()); 
           
        //2.创建相应的工作表，并向其中填充数据 
        for(int i=0; i<sheetNum; i++){ 
            //如果只有一个工作表的情况 
            if(1==sheetNum){ 
                WritableSheet sheet=wwb.createSheet(sheetName, i); 
                fillSheet(sheet, list, fieldMap, 0, list.size()-1); 
               
            //有多个工作表的情况 
            }else{ 
                WritableSheet sheet=wwb.createSheet(sheetName+(i+1), i); 
                   
                //获取开始索引和结束索引 
                int firstIndex=i*sheetSize; 
                int lastIndex=(i+1)*sheetSize-1>list.size()-1 ? list.size()-1 : (i+1)*sheetSize-1; 
                //填充工作表 
                fillSheet(sheet, list, fieldMap, firstIndex, lastIndex); 
            } 
        } 
           
        wwb.write(); 
        wwb.close(); 
       
    }catch (Exception e) { 
        e.printStackTrace(); 
       
    } 
           
} 
private static <T> void fillSheet( 
        WritableSheet sheet, 
        List<T> list, 
        Map<String,String> fieldMap, 
        int firstIndex, 
        int lastIndex 
        )throws Exception{ 
       
    //定义存放英文字段名和中文字段名的数组 
    String[] enFields=new String[fieldMap.size()]; 
    String[] cnFields=new String[fieldMap.size()]; 
       
    //填充数组 
    int count=0; 
    Iterator<Map.Entry<String,String>> iterator=fieldMap.entrySet().iterator();
    while(iterator.hasNext()){
    	Map.Entry<String, String> entry=iterator.next();
    	enFields[count]=entry.getKey();
    	cnFields[count]=entry.getValue();
    	count++;
    }
    //填充表头 
    for(int i=0;i<cnFields.length;i++){ 
        Label label=new Label(i,0,cnFields[i]); 
        sheet.addCell(label); 
    } 
       Class<?> clazz=list.get(0).getClass();
    //填充内容 
    int rowNo=1; 
    for(int index=firstIndex;index<=lastIndex;index++){ 
        //获取单个对象 
        T item=list.get(index); 
        for(int i=0;i<enFields.length;i++){ 
            Object objValue=getFieldValueByNameSequence(enFields[i], clazz,item); 
            String fieldValue=objValue==null ? "" : objValue.toString(); 
            Label label =new Label(i,rowNo,fieldValue); 
            sheet.addCell(label); 
        } 
 rowNo++; 
    } 
       
    //设置自动列宽 
    setColumnAutoSize(sheet, 5); 
} 
   
private static  Object getFieldValueByNameSequence(String fieldNameSequence, Class<?> clazz,Object item) throws Exception{ 
    Field field=clazz.getDeclaredField(fieldNameSequence);
    field.setAccessible(true);
       return field.get(item);
}   
private static void setColumnAutoSize(WritableSheet ws,int extraWith){ 
    //获取本列的最宽单元格的宽度 
    for(int i=0;i<ws.getColumns();i++){ 
        int colWith=0; 
        for(int j=0;j<ws.getRows();j++){ 
            String content=ws.getCell(i,j).getContents().toString(); 
            int cellWith=content.length(); 
            if(colWith<cellWith){ 
                colWith=cellWith; 
            } 
        } 
        //设置单元格的宽度为最宽宽度+额外宽度 
        ws.setColumnView(i, colWith+extraWith); 
    } 
       
}  
}
