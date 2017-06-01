package io.github.zh.cn.trio.aop.validation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import io.github.zh.cn.trio.aop.croe.aspect.annotation.AbstractAnnotationConfigAspect;
import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;
import io.github.zh.cn.trio.aop.validation.annotation.SignValidation;
import io.github.zh.cn.trio.aop.validation.config.ValidationBeanConfig;

@Aspect
public class TrioSignValidationAnnotationAspect
		extends AbstractAnnotationConfigAspect<ValidationBeanConfig, SignValidation> {

	@Override
	public Class<SignValidation> getAnnotationClass() {
		return SignValidation.class;
	}

	@Around("@annotation(io.github.zh.cn.trio.aop.validation.annotation.SignValidation)")
	@Override
	public Object proxyAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		return super.proxyAnnotation(proceedingJoinPoint);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ValidationBeanConfig crateConfig(SignValidation signValidation) {
		ValidationBeanConfig validationBeanConfig = new ValidationBeanConfig();
		AopStrategy<ValidationBeanConfig> aopStrategy = getBean(signValidation.aopStrategy(), AopStrategy.class,
				getDefaultAopStrategy());

		validationBeanConfig.setAopStrategy(aopStrategy);

		String[] targetTimes = new String[] { ValidationBeanConfig.TIME_BEFORE };
		validationBeanConfig.setTargetTimes(targetTimes);
		return validationBeanConfig;
	}

}
