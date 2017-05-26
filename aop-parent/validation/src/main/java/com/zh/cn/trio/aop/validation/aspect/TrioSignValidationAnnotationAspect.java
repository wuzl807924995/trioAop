package com.zh.cn.trio.aop.validation.aspect;

import com.zh.cn.trio.aop.utils.aspect.AbstractAnnotationConfigAspect;
import com.zh.cn.trio.aop.utils.base.format.Format;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;
import com.zh.cn.trio.aop.validation.annotation.SignValidation;

public class TrioSignValidationAnnotationAspect  extends AbstractAnnotationConfigAspect<ValidationBeanConfig, SignValidation>{

	@Override
	public Class<SignValidation> getAnnotationClass() {
		return SignValidation.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ValidationBeanConfig crateConfig(SignValidation signValidation) {
		ValidationBeanConfig validationBeanConfig=new ValidationBeanConfig();
		AopStrategy<ValidationBeanConfig> aopStrategy=getBean(signValidation.aopStrategy(), AopStrategy.class,getDefaultAopStrategy() );
		Format format=getBean(signValidation.format(), Format.class, getDefaultFormat());
		
		validationBeanConfig.setAopStrategy(aopStrategy);
		validationBeanConfig.setFormat(format);;
		
		String[] targetTimes=new String[]{ValidationBeanConfig.TIME_BEFORE};
		validationBeanConfig.setTargetTimes(targetTimes);
		validationBeanConfig.setErrorCode(new String[]{signValidation.errorCode()});
		validationBeanConfig.setExpression(new String[]{signValidation.validationExpress()});
		validationBeanConfig.setErrorExpressionMsg(new String[]{signValidation.errorMsg()});
		validationBeanConfig.setErrorResult(signValidation.errorReturn());
		return validationBeanConfig;
	}

}
