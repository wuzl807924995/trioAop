package io.github.zh.cn.trio.aop.croe.adapter;

import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;

/**
 * 运行环境适配器 
 *
 */
public interface RunTimeAdapter {


	/**
	 * 将当期环境为参数 执行拦截适配器
	 * @param runTimeContext 运行时上下文
	 * @param runTimeConfig  运行时配置
	 * @param targetTime 运行触发时间
	 */
	void adapterTo(RunTimeContext runTimeContext, RunTimeConfig runTimeConfig,
			String targetTime);
}
