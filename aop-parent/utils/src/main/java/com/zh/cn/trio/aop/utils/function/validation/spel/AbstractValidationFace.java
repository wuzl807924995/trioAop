package com.zh.cn.trio.aop.utils.function.validation.spel;

import com.zh.cn.trio.aop.utils.base.format.Format;
import com.zh.cn.trio.aop.utils.base.format.utils.FormatBean;
import com.zh.cn.trio.aop.utils.base.format.utils.FormatConvertUtils;
import com.zh.cn.trio.aop.utils.base.validation.bean.IValidationResult;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.validation.ValidationFace;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;

public abstract class AbstractValidationFace<E extends IValidationResult> implements ValidationFace<E>{
	
	@Override
	public E validationData(AopUtilContext<ValidationBeanConfig> aopUtilContext) {
		// 填充模式
		ValidationBeanConfig validationBeanConfig = aopUtilContext.getAopUtilConfig();
		Format format = validationBeanConfig.getFormat();
		FormatBean formatBean = FormatConvertUtils.convertContext(aopUtilContext);
		String[] expression = validationBeanConfig.getExpression();
		String[] errorCode = validationBeanConfig.getErrorCode();
		String[] errorExpression = validationBeanConfig.getErrorExpressionMsg();

		E validationResult = this.validationData(format, formatBean, expression, errorExpression,
				errorCode);
		return validationResult;
	}
	
	public abstract E validationData(Format format, Object formatBean, String[] expression,
			String[] errorExpression, String[] errorCode);

}
