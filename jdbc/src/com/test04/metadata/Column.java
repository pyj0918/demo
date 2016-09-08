package com.test04.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface Column {
	public String value() default "";
}
