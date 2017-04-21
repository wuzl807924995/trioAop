package com.zh.cn.trio.aop.utils.strategy;

import com.zh.cn.trio.aop.utils.aspect.AopUtilConfig;
import com.zh.cn.trio.aop.utils.aspect.AopUtilContext;

public interface AopStrategy {

	<T extends AopUtilConfig> void operAop(AopUtilContext<T> aopUtilContext, String targetTime);
}
