package com.zh.cn.trio.aop.hystrix.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.zh.cn.trio.aop.hystrix.annotation.TrioHystrix;
import com.zh.cn.trio.aop.utils.aspect.AbstractAnnotationConfigAspect;
import com.zh.cn.trio.aop.utils.base.format.Format;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

@Aspect
public class TrioHystrixAnnotationAspect extends AbstractAnnotationConfigAspect<ValidationBeanConfig, TrioHystrix> {

	@Override
	public Class<TrioHystrix> getAnnotationClass() {
		return TrioHystrix.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ValidationBeanConfig crateConfig(TrioHystrix trioHystrix) {
		ValidationBeanConfig validationBeanConfig = new ValidationBeanConfig();
		AopStrategy<ValidationBeanConfig> aopStrategy = getBean(trioHystrix.aopStrategy(), AopStrategy.class,
				getDefaultAopStrategy());
		Format format = getBean(trioHystrix.format(), Format.class, getDefaultFormat());

		validationBeanConfig.setAopStrategy(aopStrategy);
		validationBeanConfig.setFormat(format);

		String[] targetTimes = new String[] { ValidationBeanConfig.TIME_BEFORE };
		validationBeanConfig.setTargetTimes(targetTimes);
		validationBeanConfig.setExpression(new String[] { trioHystrix.HystrixModelBeanName() });
		return validationBeanConfig;
	}

	@Around("@annotation(com.zh.cn.trio.aop.hystrix.annotation.TrioHystrix)")
	@Override
	public Object proxyAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		return super.proxyAnnotation(proceedingJoinPoint);
	}
}
