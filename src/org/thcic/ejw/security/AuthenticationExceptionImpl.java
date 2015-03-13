/**
 * 
 */
package org.thcic.ejw.security;

import org.springframework.security.core.AuthenticationException;

/**
 * @author
 * 
 */
public class AuthenticationExceptionImpl extends AuthenticationException {
	private static final long serialVersionUID = 1L;

	public AuthenticationExceptionImpl(String msg) {
		super(msg);
	}

	public AuthenticationExceptionImpl(String msg, Throwable t) {
		super(msg, t);
	}
}
