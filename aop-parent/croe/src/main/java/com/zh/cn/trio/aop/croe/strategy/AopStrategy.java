package com.zh.cn.trio.aop.croe.strategy;

import com.zh.cn.trio.aop.croe.context.AopUtilConfig;
import com.zh.cn.trio.aop.croe.context.AopUtilContext;

/**
 * 
 *策略接口
 * @param <T>
 */
public interface AopStrategy<T extends AopUtilConfig<T>> {

	/**
	 * 执行aop
	 * @param aopUtilContext 上下文
	 * @param targetTime 触发时间
	 */
	void operAop(AopUtilContext<T> aopUtilContext, String targetTime);
}
