package com.zh.cn.trio.aop.validation.aspect;

import com.zh.cn.trio.aop.utils.aspect.AbstractAnnotationAspect;
import com.zh.cn.trio.aop.utils.base.format.Format;
import com.zh.cn.trio.aop.utils.function.validation.ValidationFace;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;
import com.zh.cn.trio.aop.validation.annotation.SignValidation;

public class TrioSignValidationAnnotationAspect  extends AbstractAnnotationAspect<ValidationBeanConfig, SignValidation>{

	AopStrategy<ValidationBeanConfig> defaultAopStrategy;
	
	Format defaultFormat;
	
	ValidationFace defaultValidationFace;
	
	@Override
	public Class<SignValidation> getAnnotationClass() {
		return SignValidation.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ValidationBeanConfig crateConfig(SignValidation signValidation) {
		ValidationBeanConfig validationBeanConfig=new ValidationBeanConfig();
		AopStrategy<ValidationBeanConfig> aopStrategy=getBean(signValidation.aopStrategy(), AopStrategy.class,defaultAopStrategy );
		Format format=getBean(signValidation.format(), Format.class, defaultFormat);
		ValidationFace validationFace=getBean(signValidation.ValidationFace(), ValidationFace.class, defaultValidationFace);
		
		validationBeanConfig.setAopStrategy(aopStrategy);
		validationBeanConfig.setFormat(format);;
		validationBeanConfig.setValidationFace(validationFace);
		
		String[] targetTimes=new String[]{ValidationBeanConfig.TIME_BEFORE};
		validationBeanConfig.setTargetTimes(targetTimes);
		validationBeanConfig.setErrorCode(new String[]{signValidation.errorCode()});
		validationBeanConfig.setExpression(new String[]{signValidation.validationExpress()});
		validationBeanConfig.setErrorExpressionMsg(new String[]{signValidation.errorMsg()});
		validationBeanConfig.setErrorResult(signValidation.errorReturn());
		return validationBeanConfig;
	}

}
