package com.zh.cn.trio.aop.utils.strategy;

import com.zh.cn.trio.aop.utils.context.AopUtilConfig;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;

public interface AopStrategy<T extends AopUtilConfig<T>> {

	void operAop(AopUtilContext<T> aopUtilContext, String targetTime);
}
