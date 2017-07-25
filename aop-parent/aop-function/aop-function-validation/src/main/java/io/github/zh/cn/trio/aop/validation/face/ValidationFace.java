package io.github.zh.cn.trio.aop.validation.face;

import io.github.zh.cn.trio.aop.validation.context.ValidationBeanContext;
import io.github.zh.cn.trio.aop.validation.result.IReturnResult;

public interface ValidationFace {

	<T> IReturnResult<T> validation(ValidationBeanContext context);

	void doValidation(ValidationBeanContext context);
}
