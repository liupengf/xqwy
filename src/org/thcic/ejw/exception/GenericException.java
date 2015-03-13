/**
 * 
 */
package org.thcic.ejw.exception;

/**
 * @author 
 */
public class GenericException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String msg;

	public GenericException(String msg) {
		setMsg(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
