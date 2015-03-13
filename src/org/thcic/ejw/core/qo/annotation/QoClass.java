package org.thcic.ejw.core.qo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface QoClass {

	public String[] defaultSortCols() default {};

	public String[] defaultSortDirs() default {};

}
