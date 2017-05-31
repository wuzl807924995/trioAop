package com.zh.cn.trio.aop.validation.aspect;

import org.aspectj.lang.annotation.Aspect;

import com.zh.cn.trio.aop.croe.aspect.annotation.AbstractAnnotationConfigAspect;
import com.zh.cn.trio.aop.croe.strategy.AopStrategy;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;
import com.zh.cn.trio.aop.validation.annotation.SignValidation;

@Aspect
public class TrioSignValidationAnnotationAspect
		extends AbstractAnnotationConfigAspect<ValidationBeanConfig, SignValidation> {

	@Override
	public Class<SignValidation> getAnnotationClass() {
		return SignValidation.class;
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
