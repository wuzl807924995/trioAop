package io.github.zh.cn.trio.aop.function;

import io.github.zh.cn.trio.aop.croe.adapter.RunTimeAdapter;
import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;

public abstract class FunctionRuntimeAdapter implements RunTimeAdapter {

	@Override
	public void toAdapter(RunTimeContext runTimeContext, RunTimeConfig runTimeConfig, String targetTime) {
		runTimeConfig.getRunTimeAdapter().adapterTo(runTimeContext, runTimeConfig, targetTime);
	}

}
