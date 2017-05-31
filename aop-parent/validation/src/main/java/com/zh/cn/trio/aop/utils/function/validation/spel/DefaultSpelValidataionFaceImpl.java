package com.zh.cn.trio.aop.utils.function.validation.spel;

import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.zh.cn.trio.aop.ValidationModel;
import com.zh.cn.trio.aop.croe.base.format.Format;
import com.zh.cn.trio.aop.croe.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.validation.ValidationFace;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;
import com.zh.cn.trio.aop.validation.bean.SimpleResult;

public class DefaultSpelValidataionFaceImpl implements ValidationFace<SimpleResult> {

	private Format format;

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	@Override
	public SimpleResult validationData(AopUtilContext<ValidationBeanConfig> aopUtilContext) {
		Map<String, ValidationModel> map = aopUtilContext.getAopUtilConfig().getValidationModelMap();
		if (CollectionUtils.isEmpty(map)) {

		}
		return null;
	}

	public SimpleResult validationData(Object formatBean, String[] expression, String[] errorExpression,
			String[] errorCode) {
		SimpleResult validationResult = new SimpleResult();

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
		validationResult.setValidationError(validationError);
		return validationResult;
	}

}
