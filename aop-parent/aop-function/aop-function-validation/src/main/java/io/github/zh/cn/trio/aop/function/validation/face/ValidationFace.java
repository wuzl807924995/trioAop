package io.github.zh.cn.trio.aop.function.validation.face;

import io.github.zh.cn.trio.aop.function.validation.context.ValidationBeanContext;
import io.github.zh.cn.trio.aop.function.validation.result.IReturnResult;

public interface ValidationFace {

	<T> IReturnResult<T> validation(ValidationBeanContext context);

	void doValidation(ValidationBeanContext context);
}
