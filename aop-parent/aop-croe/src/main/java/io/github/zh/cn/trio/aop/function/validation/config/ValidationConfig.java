package io.github.zh.cn.trio.aop.function.validation.config;

import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.function.validation.face.ValidationFace;

public class ValidationConfig extends RunTimeConfig{

	private ValidationFace validationFace;

	public ValidationFace getValidationFace() {
		return validationFace;
	}

	public void setValidationFace(ValidationFace validationFace) {
		this.validationFace = validationFace;
	}
	
	
}
