package io.github.zh.cn.trio.aop.function.validation.face;

import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.validation.result.IReturnResult;

public interface ValidationFace {

	<T> IReturnResult<T> validation(RunTimeContext context, RunTimeConfig runTimeConfig);

	void doValidation(RunTimeContext context, RunTimeConfig runTimeConfig);
}
