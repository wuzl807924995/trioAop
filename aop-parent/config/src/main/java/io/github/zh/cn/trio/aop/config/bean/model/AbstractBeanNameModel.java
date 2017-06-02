package io.github.zh.cn.trio.aop.config.bean.model;

import io.github.zh.cn.trio.aop.croe.context.AopUtilConfig;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

public class AbstractBeanNameModel implements BeanNameModel{

	@Override
	public <T extends AopUtilConfig> void beforeAop(AopUtilContext<T> aopUtilContext) {
		
	}

	@Override
	public <T extends AopUtilConfig> void afertAop(AopUtilContext<T> aopUtilContext) {
		
	}

	@Override
	public <T extends AopUtilConfig> void errorAop(AopUtilContext<T> aopUtilContext) {
		
	}

}
