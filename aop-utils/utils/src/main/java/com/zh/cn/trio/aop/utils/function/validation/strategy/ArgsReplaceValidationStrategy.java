package com.zh.cn.trio.aop.utils.function.validation.strategy;

import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.validation.ValidationFace;
import com.zh.cn.trio.aop.utils.function.validation.bean.ValidationResult;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

public class ArgsReplaceValidationStrategy implements AopStrategy<ValidationBeanConfig> {

	@Override
	public void operAop(AopUtilContext<ValidationBeanConfig> aopUtilContext, String targetTime) {
		ValidationFace validationFace = aopUtilContext.getAopUtilConfig().getValidationFace();
		ValidationResult validationResult = validationFace.validationData(aopUtilContext);
		if (!validationResult.isSuccess()) {
			Class<?>[] classes = aopUtilContext.getTargetArgsClass();
			for (int i = 0; i < classes.length; i++) {
				if (ValidationResult.class.equals(classes[i])) {
					Object[] args = aopUtilContext.getTargetArgs();
					args[i] = validationResult;
					aopUtilContext.setTargetArgs(args);
				}
			}
		}
	}

}
