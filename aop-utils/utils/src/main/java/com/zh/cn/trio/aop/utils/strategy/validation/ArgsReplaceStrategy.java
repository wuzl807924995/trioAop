package com.zh.cn.trio.aop.utils.strategy.validation;

import com.zh.cn.trio.aop.utils.base.validation.bean.ValidationResult;
import com.zh.cn.trio.aop.utils.context.AopUtilConfig;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;

public abstract class ArgsReplaceStrategy<T extends AopUtilConfig<T>> extends AbstartValidationResultStrategy<T> {

	@Override
	public void operAop(AopUtilContext<T> aopUtilContext, String targetTime) {
		ValidationResult validationResult = this.validationData(aopUtilContext);
		if (!validationResult.isSuccess()) {
			Class<?>[] classes = aopUtilContext.getTargetArgsClass();
			for (int i = 0; i < classes.length; i++) {
				if (ValidationResult.class.equals(classes[i])) {
					Object[] args = aopUtilContext.getTargetArgs();
					args[i] = validationResult;
					aopUtilContext.setTargetArgs(args);
					break;
				}
			}
		}
	}

}
