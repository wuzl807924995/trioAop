package io.github.zh.cn.trio.aop.function.validation.face;

import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.validation.config.ValidationConfig;
import io.github.zh.cn.trio.aop.function.validation.result.IReturnResult;

public abstract class AbstractArgsRepleseValidation implements ValidationFace {

	/**
	 * 如果验证失败，并且验证返回信息和方法签名一直的话将会把验证结果替换第一个找的目标参数
	 */
	@Override
	public void doValidation(RunTimeContext context,  ValidationConfig validationConfig) {
		IReturnResult<?> iReturnResult = validation(context, validationConfig);
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
