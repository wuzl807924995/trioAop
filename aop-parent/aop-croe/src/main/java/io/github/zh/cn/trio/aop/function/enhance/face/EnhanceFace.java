package io.github.zh.cn.trio.aop.function.enhance.face;

import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.enhance.config.EnhanceConfig;

public interface EnhanceFace {

	void enhaceTarget(RunTimeContext runTimeContext, EnhanceConfig enhanceConfig);
}
