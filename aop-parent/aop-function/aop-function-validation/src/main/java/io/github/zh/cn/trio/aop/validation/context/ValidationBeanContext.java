package io.github.zh.cn.trio.aop.validation.context;

import io.github.zh.cn.trio.aop.config.abs.context.AbsContext;
import io.github.zh.cn.trio.aop.validation.face.AbstractValidationFace;

public class ValidationBeanContext extends AbsContext {

	private AbstractValidationFace validationFace;

	public AbstractValidationFace getValidationFace() {
		return validationFace;
	}

	public void setValidationFace(AbstractValidationFace validationFace) {
		this.validationFace = validationFace;
	}

	@SuppressWarnings("unchecked")
	@Override
	public AbstractValidationFace getBeanModel() {
		return validationFace;
	}

}
