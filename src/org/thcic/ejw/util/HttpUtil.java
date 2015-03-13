package org.thcic.ejw.util;

import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;

/**
 * @author ZY
 * 
 */
@SuppressWarnings({ "deprecation", "resource" })
public class HttpUtil {
	private static final Log log = LogFactory.getLog(HttpUtil.class);

	public static final String HTTP_METHOD_POST = "POST";

	public static HttpResponse get(String url) {
		HttpResponse response = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(url);
			response = httpclient.execute(httpget);
		} catch (Exception e) {
			log.error(e, e);
		}
		return response;
	}

	public static HttpResponse get(String url, Map<String, String> params) {
		HttpResponse response = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(url);
			response = httpclient.execute(httpget);
		} catch (Exception e) {
			log.error(e, e);
		}
		return response;
	}

	public static HttpResponse post(String url, Map<String, String> params) {
		HttpResponse response = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(url);
			response = httpclient.execute(httppost);
		} catch (Exception e) {
			log.error(e, e);
		}
		return response;
	}

	public static Document getXML(String url, Map<String, String> params,
			String method) throws Exception {
		Document doc = null;
		HttpResponse response = null;
		if ("POST".equalsIgnoreCase(method)) {
			response = post(url, params);
		} else {
			response = get(url, params);
		}
		if (response == null) {
			log.warn("HttpResponse is null. [url: " + url + "; params: "
					+ params.toString() + "].");
			return null;
		}
		HttpEntity httpEntity = response.getEntity();
		InputStream is = httpEntity.getContent();
		DocumentBuilder builder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();

		// BufferedInputStream bin = new BufferedInputStream(is);
		// int b;
		// System.out.println("******************************");
		// while ((b = bin.read()) != -1) {
		// System.out.print("" + (char) b);
		// }
		// System.out.println("******************************");

		doc = builder.parse(is);
		return doc;
	}

	public static Cookie makeCookie(String name, String value, String domain,
			String path, int maxAgeInSeconds) {
		Cookie cookie = null;
		try {
			cookie = new Cookie(name, value);
		} catch (Exception e) {
			log.error(e, e);
			return null;
		}
		if (domain != null) {
			cookie.setDomain(domain);
		}
		if (path != null) {
			cookie.setPath(path);
		}
		cookie.setMaxAge(maxAgeInSeconds);
		return cookie;
	}

	public static Cookie getCookie(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return null;
		}
		try {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase(cookieName)) {
					return cookie;
				}
			}
		} catch (Exception e) {
			log.warn(e, e);
			return null;
		}
		return null;
	}

	public static void deleteCookie(HttpServletRequest request,
			HttpServletResponse response, String name, String domain,
			String path) {
		Cookie cookie = getCookie(request, name);
		if (cookie != null) {
			try {
				cookie = makeCookie(name, cookie.getValue(), domain, path, 0);
				response.addCookie(cookie);
			} catch (Exception e) {
				log.warn(e, e);
				return;
			}
		}
	}

	// 测试
	// public static void main(String[] arg){
	// String url = "http://www.shanbay.com/api/word/key";
	// HttpResponse response = get(url);
	//
	// }

}
