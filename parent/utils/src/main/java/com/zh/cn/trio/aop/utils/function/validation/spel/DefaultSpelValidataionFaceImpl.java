package com.zh.cn.trio.aop.utils.function.validation.spel;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.zh.cn.trio.aop.utils.base.format.Format;
import com.zh.cn.trio.aop.utils.base.format.utils.FormatBean;
import com.zh.cn.trio.aop.utils.base.format.utils.FormatConvertUtils;
import com.zh.cn.trio.aop.utils.base.validation.bean.ValidationResult;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.validation.ValidationFace;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;

public class DefaultSpelValidataionFaceImpl implements ValidationFace,ApplicationContextAware {

	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
	@Override
	public ValidationResult validationData(AopUtilContext<ValidationBeanConfig> aopUtilContext) {
		ValidationResult validationResult = new ValidationResult();
		Format format = aopUtilContext.getAopUtilConfig().getFormat();
		FormatBean formatBean = FormatConvertUtils.convertContext(aopUtilContext);
		String[] expression = aopUtilContext.getAopUtilConfig().getValidationExpression();
		String[] errorExpression = aopUtilContext.getAopUtilConfig().getValidationErrorMsg();
		
		boolean[] validationRs = new boolean[expression.length];
		String[] validationError = new String[expression.length];
		for (int i = 0; i < expression.length; i++) {
			boolean b = format.format(formatBean,applicationContext, expression[i]);
			validationRs[i] = b;
			if (!b) {
				validationError[i] = format.format(formatBean,applicationContext, errorExpression[i]);
				validationResult.setSuccess(false);
			}
		}
		validationResult.setValidation(validationRs);
		validationResult.setValidationErrorMsg(validationError);
		return validationResult;
	}


}
