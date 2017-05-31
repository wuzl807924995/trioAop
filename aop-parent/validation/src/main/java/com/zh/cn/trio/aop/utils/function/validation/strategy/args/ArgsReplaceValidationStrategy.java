package com.zh.cn.trio.aop.utils.function.validation.strategy.args;

import com.zh.cn.trio.aop.croe.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;
import com.zh.cn.trio.aop.utils.function.validation.strategy.AbstartValidationResultStrategy;
import com.zh.cn.trio.aop.validation.bean.IResult;
import com.zh.cn.trio.aop.validation.bean.SimpleResult;

public class ArgsReplaceValidationStrategy
		extends AbstartValidationResultStrategy<ValidationBeanConfig, SimpleResult> {

	public Class<SimpleResult> getEClass() {
		return SimpleResult.class;
	}

	public SimpleResult validationData(AopUtilContext<ValidationBeanConfig> aopUtilContext) {
		// return getValidationFace().validationData(aopUtilContext);
		return null;
	}

	@Override
	public void operAop(AopUtilContext<ValidationBeanConfig> aopUtilContext, String targetTime) {
		IResult validationResult = this.validationData(aopUtilContext);
		// 验证结果返回失败时
		if (!validationResult.isSuccess()) {
			Class<?>[] classes = aopUtilContext.getTargetArgsClass();
			Class<?> ecls = getEClass();
			for (int i = 0; i < classes.length; i++) {
				// 加载替换实参
				if (ecls.equals(classes[i])) {
					Object[] args = aopUtilContext.getTargetArgs();
					args[i] = validationResult;
					aopUtilContext.setTargetArgs(args);
					break;
				}
			}
		}
	}

}
