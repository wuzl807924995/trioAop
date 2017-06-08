package io.github.zh.cn.trio.aop.validation.strategy.args;

import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.validation.bean.IResult;
import io.github.zh.cn.trio.aop.validation.config.ValidationBeanConfig;
import io.github.zh.cn.trio.aop.validation.strategy.AbstartValidationResultStrategy;

public class ArgsReplaceStrategy<E extends IResult> extends AbstartValidationResultStrategy<E> {

	@Override
	public void operAop(AopUtilContext<ValidationBeanConfig> aopUtilContext, String targetTime) {
		IResult validationResult = this.validationData(aopUtilContext);
		// 验证结果返回失败时
		if (!validationResult.isSuccess()) {
			Class<?>[] classes = aopUtilContext.getTargetArgsClass();
			Class<?> ecls = getValidationFace().getEClass();
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
