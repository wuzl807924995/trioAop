package io.github.zh.cn.trio.aop.validation.face;

import io.github.zh.cn.trio.aop.config.abs.context.AbsContext;
import io.github.zh.cn.trio.aop.validation.result.IReturnResult;

public interface ValidationFace {

	<T> IReturnResult<T> validation(AbsContext context);
}
