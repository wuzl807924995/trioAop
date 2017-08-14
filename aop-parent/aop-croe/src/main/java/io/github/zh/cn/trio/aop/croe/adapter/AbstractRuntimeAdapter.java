package io.github.zh.cn.trio.aop.croe.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;

public abstract class AbstractRuntimeAdapter implements RunTimeAdapter {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void adapterTo(RunTimeContext runTimeContext, RunTimeConfig runTimeConfig, String targetTime) {
		if (RunTimeConfig.TIME_BEFORE.equals(targetTime)) {
			beforeAop(runTimeContext, runTimeConfig);
		} else if (RunTimeConfig.TIME_AFTER.equals(targetTime)) {
			afertAop(runTimeContext, runTimeConfig);
		} else if (RunTimeConfig.TIME_ERROR.equals(targetTime)) {
			errorAop(runTimeContext, runTimeConfig);
		} else if (RunTimeConfig.TIME_AROUND_STARAT.equals(targetTime)) {
			aroundStartAop(runTimeContext, runTimeConfig);
		} else if (RunTimeConfig.TIME_AROUND_END.equals(targetTime)) {
			aroundEndAop(runTimeContext, runTimeConfig);
		} else {
			logger.error("operAop has not time to target ");
		}
	}

	public void aroundStartAop(RunTimeContext runTimeContext, RunTimeConfig runTimeConfig) {
	}

	public void aroundEndAop(RunTimeContext runTimeContext, RunTimeConfig runTimeConfig) {
	}

	public void errorAop(RunTimeContext runTimeContext, RunTimeConfig runTimeConfig) {
	}

	public void afertAop(RunTimeContext runTimeContext, RunTimeConfig runTimeConfig) {
	}

	public void beforeAop(RunTimeContext runTimeContext, RunTimeConfig runTimeConfig) {
	}

}
