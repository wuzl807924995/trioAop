package io.github.zh.cn.trio.aop.function.logger.strategy.asyn;

import org.springframework.scheduling.annotation.Async;

import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.function.logger.strategy.LoggerStrategy;

public class AsynLoggerStrategy extends LoggerStrategy {

	@Async
	@Override
	public void operAop(AopUtilContext aopUtilContext, String targetTime) {
		super.operAop(aopUtilContext, targetTime);
	}

}
