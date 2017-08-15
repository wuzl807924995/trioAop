package io.github.zh.cn.trio.aop.croe.adapter;

import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;

public interface RunTimeAdapter {

	void toAdapter(RunTimeContext runTimeContext, RunTimeConfig runTimeConfig, String targetTime);

	void adapterTo(RunTimeContext runTimeContext, RunTimeConfig runTimeConfig, String targetTime);
}
