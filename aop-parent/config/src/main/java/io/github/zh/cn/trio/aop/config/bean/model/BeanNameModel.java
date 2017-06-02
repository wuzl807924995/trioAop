package io.github.zh.cn.trio.aop.config.bean.model;

import io.github.zh.cn.trio.aop.croe.context.AopUtilConfig;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

public interface BeanNameModel {

	public <T extends AopUtilConfig> void beforeAop(AopUtilContext<T> aopUtilContext);

	public <T extends AopUtilConfig> void afertAop(AopUtilContext<T> aopUtilContext);

	public <T extends AopUtilConfig> void errorAop(AopUtilContext<T> aopUtilContext);

}
