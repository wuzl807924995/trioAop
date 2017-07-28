package io.github.zh.cn.trio.aop.function.dynamic.face;

import io.github.zh.cn.trio.aop.function.dynamic.context.DynamicContext;

public interface DynamicFace {

	void dynamicStart(DynamicContext dynamicContext);

	void dynamicEnd(DynamicContext dynamicContext);
}
