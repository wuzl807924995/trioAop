package com.zh.cn.trio.aop.utils.function.validation.config;

import com.zh.cn.trio.aop.utils.context.AopUtilConfig;
import com.zh.cn.trio.aop.utils.function.validation.ValidationFace;

public class ValidationBeanConfig extends AopUtilConfig<ValidationBeanConfig> {

	private String[] validationExpression;

	private String[] validationErrorMsg;

	private ValidationFace validationFace;

	public String[] getValidationExpression() {
		return validationExpression;
	}

	public void setValidationExpression(String[] validationExpression) {
		this.validationExpression = validationExpression;
	}

	public String[] getValidationErrorMsg() {
		return validationErrorMsg;
	}

	public void setValidationErrorMsg(String[] validationErrorMsg) {
		this.validationErrorMsg = validationErrorMsg;
	}

	public ValidationFace getValidationFace() {
		return validationFace;
	}

	public void setValidationFace(ValidationFace validationFace) {
		this.validationFace = validationFace;
	}

}
