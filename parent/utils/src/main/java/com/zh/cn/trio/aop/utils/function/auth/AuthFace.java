package com.zh.cn.trio.aop.utils.function.auth;

import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.auth.config.AuthBeanConfig;

public interface AuthFace {

	boolean auth(AopUtilContext<AuthBeanConfig> aopUtilContext);
}
