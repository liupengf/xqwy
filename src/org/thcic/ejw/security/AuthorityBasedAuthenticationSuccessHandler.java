/**
 * 
 */
package org.thcic.ejw.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * 根据用户角色决定用户登录后的URL。
 * 
 * @author
 */
@Component
public class AuthorityBasedAuthenticationSuccessHandler extends
		SimpleUrlAuthenticationSuccessHandler {
	protected final Log log = LogFactory.getLog(this.getClass());

	public AuthorityBasedAuthenticationSuccessHandler() {
		/*
		 * Authentication auth = SecurityContextHolder.getContext()
		 * .getAuthentication(); UserDetails userDetails = (UserDetails)
		 * auth.getPrincipal(); Collection<? extends GrantedAuthority>
		 * collection = userDetails .getAuthorities();
		 */

		setDefaultTargetUrl("/f/main");
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String targetUrl = request.getParameter("url");
		
		if (targetUrl==null||targetUrl.equals("")) {
			targetUrl = "/f/main";
		}
       
		getRedirectStrategy().sendRedirect(request, response, targetUrl);

		clearAuthenticationAttributes(request);
	}

/*	private String determineTargetUrl(Authentication authentication) {
		// 不同角色跳转到不同页面
		Map<String, String> authorityUrlMap = new HashMap<String, String>();
		authorityUrlMap.put("THU_ROLE_jxpg_js", "/f/xs/main");//教师	
		authorityUrlMap.put("THU_ROLE_jxpg_jpzx", "/f/xs/main");//学生
		authorityUrlMap.put("THU_ROLE_jxpg_jwy", "/f/xs/main");//教师	
		authorityUrlMap.put("THU_ROLE_jxpg_jxzr", "/f/xs/main");//教师	
		authorityUrlMap.put("THU_ROLE_jxpg_xs", "/f/xs/main");//教师	
		try {
			for (GrantedAuthority authority : authentication.getAuthorities()) {
				for (Map.Entry<String, String> entry : authorityUrlMap
						.entrySet()) {
					if (authority.getAuthority().equals(entry.getKey())) {
						return entry.getValue();
					}
				}
			}
		} catch (Exception e) {
			log.warn(e, e);
		}
		return null;
	}*/

}
