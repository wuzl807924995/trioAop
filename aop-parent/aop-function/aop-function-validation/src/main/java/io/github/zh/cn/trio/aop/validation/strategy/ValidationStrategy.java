package io.github.zh.cn.trio.aop.validation.strategy;

import org.springframework.stereotype.Component;

import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.croe.strategy.AbstractAopStrategy;
import io.github.zh.cn.trio.aop.validation.context.ValidationBeanContext;

@Component("validationStrategy")
public class ValidationStrategy extends AbstractAopStrategy {

	
	@Override
	public void beforeAop(AopUtilContext aopUtilContext) {
		ValidationBeanContext validationBeanContext=(ValidationBeanContext) aopUtilContext;
		validationBeanContext.getValidationFace().doValidation(validationBeanContext);
	}
}
