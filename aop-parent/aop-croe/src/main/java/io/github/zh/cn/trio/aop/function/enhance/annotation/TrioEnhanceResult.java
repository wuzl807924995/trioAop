package io.github.zh.cn.trio.aop.function.enhance.annotation;

public @interface TrioEnhanceResult {

	String target() default "";
	
	String type() ;
	
	String typeArgs() default "";
}
