package com.zh.cn.trio.aop.utils.base.validation;

import com.zh.cn.trio.aop.utils.base.format.Format;
import com.zh.cn.trio.aop.utils.base.validation.bean.ValidationResult;

public class DefaultValidationImpl implements Validation{

	@Override
	public ValidationResult validationData(Format format, Object formatBean, String[] expression,
			String[] errorExpression, String[] errorCode) {
		ValidationResult validationResult = new ValidationResult();

		boolean[] validationRs = new boolean[expression.length];
		String[] validationCode = new String[expression.length];
		Object[] validationError = new Object[expression.length];
		// 遍历验证
		for (int i = 0; i < expression.length; i++) {
			boolean b = format.format(formatBean, expression[i]);
			validationRs[i] = b;
			if (!b) {
				// 失败加载错误消息
				validationError[i] = format.format(formatBean, errorExpression[i]);
				validationCode[i] = errorCode[i];
				validationResult.setSuccess(false);
			}
		}
		validationResult.setValidation(validationRs);
		validationResult.setValidationErrorCode(validationCode);
		validationResult.setValidationErrorMsg(validationError);
		return validationResult;
	}
}
