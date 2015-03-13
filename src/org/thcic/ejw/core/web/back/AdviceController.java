/**
 * 
 */
package org.thcic.ejw.core.web.back;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thcic.ejw.core.ro.ControllerResult;
import org.thcic.ejw.exception.GenericException;

/**
 * 基路径：/rest/*
 * 
 * @author zhangyu octopusthu@gmail.com
 */
@ControllerAdvice
public class AdviceController {
	protected static final Log log = LogFactory.getLog(AdviceController.class);

	@ExceptionHandler
	public @ResponseBody
	ControllerResult handleException(Exception e) {
		log.error("Exception occurred！", e);
		return ControllerResult.valueOf(ControllerResult.ERROR, "操作异常！");
	}

	@ExceptionHandler
	public @ResponseBody
	ControllerResult handleGenericException(GenericException ex) {
		// log.warn("GenericException occurred: " + ex.getMsg(), ex);
		return ControllerResult.valueOf(ControllerResult.ERROR, ex.getMsg());
	}

	/**
	 * by billy 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
	 * 
	 * @param binder
	 */
	// @InitBinder
	// public void initBinder(WebDataBinder binder) {
	// binder.registerCustomEditor(Date.class, new DateEditor());
	// }

}
