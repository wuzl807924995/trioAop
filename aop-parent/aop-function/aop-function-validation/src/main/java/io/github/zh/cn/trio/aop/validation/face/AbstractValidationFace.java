package io.github.zh.cn.trio.aop.validation.face;

import io.github.zh.cn.trio.aop.config.abs.context.AbsContext;
import io.github.zh.cn.trio.aop.config.abs.model.AbsBeanModel;

public abstract class AbstractValidationFace implements ValidationFace, AbsBeanModel {

	@Override
	public void afertAop(AbsContext context) {

	}

	@Override
	public void errorAop(AbsContext context) {

	}

}
