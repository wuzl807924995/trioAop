package com.zh.cn.trio.aop.utils.aspect;

import java.lang.annotation.Annotation;

import com.zh.cn.trio.aop.utils.base.format.Format;
import com.zh.cn.trio.aop.utils.context.AopUtilConfig;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

public abstract class AbstractAnnotationConfigAspect<T extends AopUtilConfig<T>, E extends Annotation>
extends AbstractAnnotationAspect<T,E> {

	private AopStrategy<T> defaultAopStrategy;

	private Format defaultFormat;

	public AopStrategy<T> getDefaultAopStrategy() {
		return defaultAopStrategy;
	}

	public void setDefaultAopStrategy(AopStrategy<T> defaultAopStrategy) {
		this.defaultAopStrategy = defaultAopStrategy;
	}

	public Format getDefaultFormat() {
		return defaultFormat;
	}

	public void setDefaultFormat(Format defaultFormat) {
		this.defaultFormat = defaultFormat;
	}

	
	
}
