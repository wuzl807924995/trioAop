package io.github.zh.cn.trio.aop.function.dynamic.strategy;

import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.croe.strategy.AbstractAopStrategy;
import io.github.zh.cn.trio.aop.function.dynamic.context.DynamicContext;

public class DynamicStrategy extends AbstractAopStrategy {

	@Override
	public void beforeAop(AopUtilContext aopUtilContext) {
		DynamicContext dynamicContext = (DynamicContext) aopUtilContext;
		dynamicContext.getDynamicFace().dynamicStart(dynamicContext);
	}

	@Override
	public void afertAop(AopUtilContext aopUtilContext) {
		DynamicContext dynamicContext = (DynamicContext) aopUtilContext;
		dynamicContext.getDynamicFace().dynamicEnd(dynamicContext);
	}

	@Override
	public void errorAop(AopUtilContext aopUtilContext) {
		this.afertAop(aopUtilContext);
	}
}
