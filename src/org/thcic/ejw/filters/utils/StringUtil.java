package org.thcic.ejw.filters.utils;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;

/**
 * 字符串辅助类，处理常用的字符串操作（处理特殊字符）
 * 
 */

public class StringUtil {
	/**
	 * 缺省的字符串分割符
	 */
	public static String DEFAULT_DELIM = "|";

	/**
	 * 此方法将给出的字符串source使用delim划分为单词数组。 注意：分隔字符串中每一个 <b>(ANY) </b>的字符都作为独立的分割符。 <br>
	 * 举个例子： <br>
	 * "mofit.com.cn"用"com"分割后的结果是三个字符串"fit."、"."和"n"，而不是"mofit."和".cn"。
	 * 
	 * @param source
	 *            需要进行划分的原字符串
	 * @param delim
	 *            单词的分隔字符串
	 * @return 划分以后的数组，如果source为null的时候返回以source为唯一元素的数组，
	 *         如果delim为null则使用逗号作为分隔字符串。
	 */
	public static String[] split(String source, String delim) {
		String[] wordLists;
		if (source == null) {
			wordLists = new String[1];
			wordLists[0] = source;
			return wordLists;
		}
		if (delim == null) {
			delim = DEFAULT_DELIM;
		}
		StringTokenizer st = new StringTokenizer(source, delim);

		int total = st.countTokens();
		wordLists = new String[total];
		for (int i = 0; i < total; i++) {
			wordLists[i] = st.nextToken();
		}
		return wordLists;
	}

	/**
	 * 检查参数值
	 * 
	 * @param path
	 *            log文件路径
	 * @param request
	 * 
	 * @param specialCharacter_array
	 *            特殊字符数组
	 * @param str
	 *            要检查的参数值
	 * @return
	 */
	public static boolean checkSpecialCharacter(String path,
			HttpServletRequest request, String[] specialCharacter_array,
			String paramName,String paramValue) {
		for (int i = 0; i < specialCharacter_array.length; i++) {
			if (paramValue.indexOf(specialCharacter_array[i]) >= 0) {
				
				//FileUtil.appendString(path, LogUtil.getLog(request,paramName,paramValue));
				return true;
			}
		}
		return false;
	}

	/**
	 * 替换特殊字符
	 * 
	 * @param specialCharacter_array
	 * @param str
	 * @return
	 */
	public static String replaceSpecialCharacter(
			String[] specialCharacter_array, String str) {
		for (int i = 0; i < specialCharacter_array.length; i++) {
			if (str.indexOf(specialCharacter_array[i]) >= 0) {
				str = str.replace(specialCharacter_array[i], "");
			}
		}
		return str;
	}

	/**
	 * 转义特殊字符
	 * 
	 * @param specialCharacter_array
	 * @param str
	 * @return
	 */
	public static String escapeSpecialCharacter(
			String[] specialCharacter_array, String str) {
		for (int i = 0; i < specialCharacter_array.length; i++) {
			if (str.indexOf(specialCharacter_array[i]) >= 0) {
				str = escapeXssEncode(str);				
			}
		}
		return str;
	}
	
	/**
	* 
	* 转义sql、javascript语句片段，并将容易引起xss攻击的半角字符直接替换成全角字符
	*
	* @param value
	* @return
	*/
	private static String escapeXssEncode(String value) {
		if(StringUtils.isBlank(value)) return value;
		String result = value;
		//对中文参数会有影响
		/*result = StringEscapeUtils.escapeHtml(value);
		result = StringEscapeUtils.escapeSql(value);
		result = StringEscapeUtils.escapeJavaScript(result);*/	
		
		//避免客户端使用 encodeURI时造成中文转码异常
		/*result = result.replace('\'','＼');
		result = result.replace('/', '／');*/
		//ajax序列换表单时造成错误
//		result = result.replace('%', '％'); 
		//有些系统参数从客户端过来的时候是通过“;”连接
//		result = result.replace(';', '；');
		
		//直接过滤特殊字符，但有时候不能这么做。（比如有富文本编辑器时）		
		result = result.replace('<', '＜');
		result = result.replace('>', '＞'); 
		result = result.replace('"', '＂');
		result = result.replace('\'', '‘');//单引号转码
		result = result.replace('(', '（'); 
		result = result.replace(')', '）'); 
		result = result.replace('&', '＆'); 
		result = result.replace('+', '＋'); 
		result = result.replace('#', '＃'); 
	
		return result;
		
	}
	
	public  static void main(String[] args){
		String specialCharacters = "'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,|script";
		String target = "None";
		String[] specialCharacter_array = StringUtil.split(specialCharacters, DEFAULT_DELIM);
		System.out.println("result==>"+StringUtil.escapeSpecialCharacter(specialCharacter_array, target));
	}
}