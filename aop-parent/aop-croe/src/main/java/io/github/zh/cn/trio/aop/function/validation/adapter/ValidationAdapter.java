package io.github.zh.cn.trio.aop.function.validation.adapter;

import io.github.zh.cn.trio.aop.croe.adapter.RunTimeAdapter;
import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.validation.face.ValidationFace;

public class ValidationAdapter implements RunTimeAdapter{

	private ValidationFace validationFace;

	public ValidationFace getValidationFace() {
		return validationFace;
	}

	public void setValidationFace(ValidationFace validationFace) {
		this.validationFace = validationFace;
	}

	@Override
	public void adapterTo(RunTimeContext runTimeContext, RunTimeConfig runTimeConfig, String targetTime) {
		validationFace.doValidation(runTimeContext, runTimeConfig);
	}

}
