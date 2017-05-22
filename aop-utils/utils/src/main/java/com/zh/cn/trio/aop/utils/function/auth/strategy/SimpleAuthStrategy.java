package com.zh.cn.trio.aop.utils.function.auth.strategy;

import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.auth.config.AuthBeanConfig;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

public class SimpleAuthStrategy implements AopStrategy<AuthBeanConfig>{

	@Override
	public void operAop(AopUtilContext<AuthBeanConfig> aopUtilContext, String targetTime) {
		
	}

}
