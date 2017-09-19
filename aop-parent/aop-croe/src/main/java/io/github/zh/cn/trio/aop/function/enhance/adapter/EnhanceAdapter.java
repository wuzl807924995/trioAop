package io.github.zh.cn.trio.aop.function.enhance.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.zh.cn.trio.aop.croe.adapter.RunTimeAdapter;
import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.enhance.config.EnhanceConfig;
import io.github.zh.cn.trio.aop.function.enhance.face.EnhanceFace;

public class EnhanceAdapter  implements RunTimeAdapter {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private EnhanceFace enhanceFace;

	public EnhanceFace getEnhanceFace() {
		return enhanceFace;
	}
	
	public void setEnhanceFace(EnhanceFace enhanceFace) {
		this.enhanceFace = enhanceFace;
	}

	@Override
	public void adapterTo(RunTimeContext runTimeContext, RunTimeConfig runTimeConfig, String targetTime) {
		if (runTimeConfig instanceof EnhanceConfig) {
			EnhanceConfig enhanceConfig = (EnhanceConfig) runTimeConfig;
			enhanceFace.enhaceTarget(runTimeContext,enhanceConfig);
		} else {
			logger.warn(runTimeConfig + "is not LoggerConfig");
		}
	}
}
