package com.itplayer.common.serialutils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface SerialNumberHearder {
	/**
	 * 前缀
	 */
	String prefix() default "";

	/**
	 * 后缀
	 */
	String suffix() default "";
}
