package io.github.zh.cn.trio.aop.validation.face.impl;

import java.util.Map;

import org.springframework.util.CollectionUtils;

import io.github.zh.cn.trio.aop.croe.base.format.Format;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.validation.bean.SimpleResult;
import io.github.zh.cn.trio.aop.validation.config.ValidationBeanConfig;
import io.github.zh.cn.trio.aop.validation.face.ValidationFace;
import io.github.zh.cn.trio.aop.validation.model.ValidationModel;

public class DefaultValidataionFaceImpl implements ValidationFace<SimpleResult> {

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
			for (String modelKey : map.keySet()) {
				ValidationModel tmpModel = map.get(modelKey);
				return tmpModel.validationData(aopUtilContext);
			}
		}
		SimpleResult simpleResult = new SimpleResult();
		simpleResult.setSuccess(true);
		return simpleResult;
	}

	@Override
	public Class<SimpleResult> getEClass() {
		return SimpleResult.class;
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
