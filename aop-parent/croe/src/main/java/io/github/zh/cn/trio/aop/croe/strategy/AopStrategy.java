package io.github.zh.cn.trio.aop.croe.strategy;

import io.github.zh.cn.trio.aop.croe.context.AopUtilConfig;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

/**
 * 
 * 策略接口
 */
public interface AopStrategy {

	/**
	 * 执行aop
	 * 
	 * @param aopUtilContext
	 *            上下文
	 * @param targetTime
	 *            触发时间
	 */
	<T extends AopUtilConfig> void operAop(AopUtilContext<T> aopUtilContext, String targetTime);

	void operAop1(AopUtilContext<?> aopUtilContext, String targetTime);
}
