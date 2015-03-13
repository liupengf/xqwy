package org.thcic.ejw.util;

public class Constants {

	public static final String AUTHORITY_PREFIX_THU_TYPE = "THU_TYPE_"; // 统一身份认证 - 用户类别
	public static final String AUTHORITY_PREFIX_THU_ROLE = "THU_ROLE_"; // 统一身份认证 - 用户角色（来自统一权限）

	public static final String AUTHORITY_THU_AUTHENTICATED = "authenticateduser"; // 统一权限 - 已认证用户的roleId	
	public static final String SHTG="通过";
	public static final String SHWTG="未通过";
	public static final String DSH="待审核";
	
	public static final String YWC = "已完成";
	public static final String WWC = "未完成";
	public static final String YWC_Val = "1";
	public static final String WWC_Val = "0";
	
	public static final String ZBJBXX="学校";
	public static final String ZBJBYX="院系";
	public static final String ZBJBGR="个人";
	public static final String ZBJBLB="类别";
	
	public static final String TCRLXYX="院系";
	public static final String TCRLXJS="教师";
	public static final String TCRLXXX="学校";
	
	public static final String ZBLBGR="个人";
	public static final String XJYS="校级预设";
	public static final String ZBFLJS="教师";
	public static final String ZBFLZJ="助教";
	public static final String ZBFLKC="课程";
	
	public static final String XNXQID="32_01";//学年学期id
	
	public static final String KG_GCPG_YX= "32_11";//过程评估开关
	public static final String KG_JSZB_YX= "32_14";//教师指标院系申请开关
	//public static final String KG_JSZB_GR = "32_15";//教师指标个人申请开关
	public static final String KG_XQZB_YX = "32_16";//院系维护学期指标开关
	public static final String KG_XQZB_JS = "32_17";//教师维护学期指标开关
	public static final String KG_PGWJ_XS = "32_18";//学生填写评估问卷开关
	public static final String KG_GRBB_JS = "32_19";//教师查看个人报表开关
	public static final String KG_XQKC_SFCP = "32_20";//维护是否参评开关
	public static final String KG_XQKC_PGLB = "32_21";//维护评估类别变化开关
	public static final String KG_ZJWH_YX = "32_22";//维护评估类别变化开关
	 
	public static final String KG_K="开";
	public static final String KG_G ="关";
	public static final int ZBCOUNTJSXX=4;
	public static final int ZBCOUNTJSYX=1;
	public static final int ZBCOUNTJSLB=1;
	public static final int ZBCOUNTKC=1;
	public static final int ZBCOUNTZJ=2;
	public static final int ZBCOUNTGR=1;
	
	public static final String RYLBJS="教师";
	public static final String RYLBZJ="助教";
	public static final String REMINDER_ADD="对不起，现在不允许维护，请联系管理员";
	public static final String REMINDER_SQ="对不起，现在不允许申请，请联系管理员";
	public static final String REMINDER_WJ="对不起，现在不是填写问卷时间";
	
	public static final String SFSX_Y = "是";
	public static final String SFSX_N = "否";
	
	//指标数组（学校4、助教2、课程1）
	public static final int ZBXH_XX[]={1,2,3,4};
	public static final int ZBXH_ZJ[]={10,11};
	public static final int ZBXH_KC[]={21};
	public static final String ZBLYZBK="指标库";
	public static final String ZBLYXZ="新增";
	
}
