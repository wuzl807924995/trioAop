package io.github.zh.cn.trio.aop.dynamic.face;

import io.github.zh.cn.trio.aop.dynamic.context.DynamicContext;

public interface DynamicFace {

	void dynamicStart(DynamicContext dynamicContext);

	void dynamicEnd(DynamicContext dynamicContext);
}
