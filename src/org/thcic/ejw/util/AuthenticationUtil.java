package org.thcic.ejw.util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.thcic.ejw.security.AuthenticationExceptionImpl;

public class AuthenticationUtil {

	protected static final Log log = LogFactory
			.getLog(AuthenticationUtil.class);

	/**
	 * 获取用户对象
	 * 
	 * @return
	 * @throws AuthenticationException
	 */
	public static UserDetails getUserDetails() throws AuthenticationException {
		try {
			return (UserDetails) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
		} catch (Exception e) {
			throw new AuthenticationExceptionImpl(
					"Exception retrieving UserDetails.", e);
		}
	}
	/**
	 * 获取用户的证件号
	 * @return
	 */
	public static String getUserZjh() {
		return "";
	}


}
