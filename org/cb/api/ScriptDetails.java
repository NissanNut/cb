package org.cb.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * @author Troy
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ScriptDetails {
	double version() default 0.01;
	String name() default "Unknown";
	String description() default "Unknown";
	String author() default "Unknown"; 
}
