package io.github.zh.cn.trio.aop.croe.aspect;

import org.springframework.beans.BeanUtils;

import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;

public class SimpleAspect<E extends RunTimeConfig> extends AbstractAopAspect {

	private E runtimeConfig;

	public E getRuntimeConfig() {
		return runtimeConfig;
	}

	public void setRuntimeConfig(E runtimeConfig) {
		this.runtimeConfig = runtimeConfig;
	}

	@Override
	public RunTimeConfig initConfig(RunTimeContext runTimeContext) {
		RunTimeConfig temp=new RunTimeConfig();
		BeanUtils.copyProperties(this.runtimeConfig, temp);
		return temp;
	}


}
