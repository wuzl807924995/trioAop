package com.zh.cn.trio.aop.utils.function.validation.spel;

import com.zh.cn.trio.aop.utils.base.format.Format;
import com.zh.cn.trio.aop.utils.base.format.utils.FormatBean;
import com.zh.cn.trio.aop.utils.base.format.utils.FormatConvertUtils;
import com.zh.cn.trio.aop.utils.base.validation.bean.ValidationResult;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.validation.ValidationFace;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;

public class DefaultSpelValidataionFaceImpl implements ValidationFace {

	@Override
	public ValidationResult validationData(AopUtilContext<ValidationBeanConfig> aopUtilContext) {
		ValidationResult validationResult = new ValidationResult();
		//填充模式
		Format format = aopUtilContext.getAopUtilConfig().getFormat();
		FormatBean formatBean = FormatConvertUtils.convertContext(aopUtilContext);
		String[] expression = aopUtilContext.getAopUtilConfig().getValidationExpression();
		String[] errorExpression = aopUtilContext.getAopUtilConfig().getValidationErrorMsg();
		boolean[] validationRs = new boolean[expression.length];
		String[] validationError = new String[expression.length];
		//遍历验证
		for (int i = 0; i < expression.length; i++) {
			boolean b = format.format(formatBean, expression[i]);
			validationRs[i] = b;
			if (!b) {
				//失败加载错误消息
				validationError[i] = format.format(formatBean, errorExpression[i]);
				validationResult.setSuccess(false);
			}
		}
		validationResult.setValidation(validationRs);
		validationResult.setValidationErrorMsg(validationError);
		return validationResult;
	}


}
