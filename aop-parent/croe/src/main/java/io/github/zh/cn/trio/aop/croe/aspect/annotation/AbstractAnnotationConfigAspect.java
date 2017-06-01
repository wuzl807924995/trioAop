package io.github.zh.cn.trio.aop.croe.aspect.annotation;

import java.lang.annotation.Annotation;

import io.github.zh.cn.trio.aop.croe.context.AopUtilConfig;
import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;

public abstract class AbstractAnnotationConfigAspect<T extends AopUtilConfig<T>, E extends Annotation>
		extends AbstractAnnotationAspect<T, E> {

	private AopStrategy<T> defaultAopStrategy;

	public AopStrategy<T> getDefaultAopStrategy() {
		return defaultAopStrategy;
	}

	public void setDefaultAopStrategy(AopStrategy<T> defaultAopStrategy) {
		this.defaultAopStrategy = defaultAopStrategy;
	}

}
