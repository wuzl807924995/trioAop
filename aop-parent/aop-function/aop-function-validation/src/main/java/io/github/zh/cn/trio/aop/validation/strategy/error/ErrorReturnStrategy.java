package io.github.zh.cn.trio.aop.validation.strategy.error;

import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.validation.bean.IReturnResult;
import io.github.zh.cn.trio.aop.validation.config.ValidationBeanConfig;
import io.github.zh.cn.trio.aop.validation.strategy.AbstartValidationResultStrategy;

public class ErrorReturnStrategy<E extends IReturnResult> extends AbstartValidationResultStrategy<E> {

	@Override
	public void operAop(AopUtilContext<ValidationBeanConfig> aopUtilContext, String targetTime) {
		E validationResult = this.validationData(aopUtilContext);
		// 验证失败
		if (!validationResult.isSuccess()) {
			aopUtilContext.setResultObject(validationResult.getRerrorResult());
		}

	}
}