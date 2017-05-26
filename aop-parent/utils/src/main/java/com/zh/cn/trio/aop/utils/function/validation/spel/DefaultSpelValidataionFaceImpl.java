package com.zh.cn.trio.aop.utils.function.validation.spel;

import com.zh.cn.trio.aop.utils.base.format.Format;
import com.zh.cn.trio.aop.utils.base.format.utils.FormatBean;
import com.zh.cn.trio.aop.utils.base.format.utils.FormatConvertUtils;
import com.zh.cn.trio.aop.utils.base.validation.Validation;
import com.zh.cn.trio.aop.utils.base.validation.bean.ValidationResult;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.validation.ValidationFace;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;

public class DefaultSpelValidataionFaceImpl implements ValidationFace {
	
	private Validation validation;

	
	public Validation getValidation() {
		return validation;
	}


	public void setValidation(Validation validation) {
		this.validation = validation;
	}


	@Override
	public ValidationResult validationData(AopUtilContext<ValidationBeanConfig> aopUtilContext) {
		//填充模式
		ValidationBeanConfig validationBeanConfig = aopUtilContext.getAopUtilConfig();
		Format format = validationBeanConfig.getFormat();
		FormatBean formatBean = FormatConvertUtils.convertContext(aopUtilContext);
		String[] expression = validationBeanConfig.getExpression();
		String[] errorCode=validationBeanConfig.getErrorCode();
		String[] errorExpression = validationBeanConfig.getErrorExpressionMsg();
		
		ValidationResult validationResult = validation.validationData(format, formatBean, expression, errorExpression, errorCode);
		return validationResult;
	}


}
