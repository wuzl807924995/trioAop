package io.github.zh.cn.trio.aop.croe.strategy;

import io.github.zh.cn.trio.aop.croe.context.AopUtilConfig;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

/**
 * 
 *策略接口
 * @param <T> 子类配置
 */
public interface AopStrategy<T extends AopUtilConfig<T>> {

	/**
	 * 执行aop
	 * @param aopUtilContext 上下文
	 * @param targetTime 触发时间
	 */
	void operAop(AopUtilContext<T> aopUtilContext, String targetTime);
}
