package io.github.zh.cn.trio.aop.function.validation.face;

import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.validation.result.IReturnResult;

public abstract class AbstractArgsRepleseValidation implements ValidationFace {

	@Override
	public void doValidation(RunTimeContext context, RunTimeConfig runTimeConfig) {
		IReturnResult<?> iReturnResult = validation(context, runTimeConfig);
		if (!iReturnResult.isSuccess()) {
			Class<?> cls = getErrorClass();
			Object[] args = context.getTargetArgs();
			for (int i = 0; i < context.getTargetArgs().length; i++) {
				if (cls.equals(args[i].getClass())) {
					args[i] = cls;
				}
			}
			context.setTargetArgs(args);
		}
	}

	public Class<?> getErrorClass() {
		return IReturnResult.class;
	}
}
