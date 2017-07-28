package io.github.zh.cn.trio.aop.function.validation.context;

import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.function.validation.face.ValidationFace;

public class ValidationBeanContext extends AopUtilContext {

	private ValidationFace validationFace;

	public ValidationFace getValidationFace() {
		return validationFace;
	}

	public void setValidationFace(ValidationFace validationFace) {
		this.validationFace = validationFace;
	}

}
