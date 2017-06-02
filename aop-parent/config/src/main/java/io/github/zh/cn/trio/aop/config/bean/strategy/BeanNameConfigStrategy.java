package io.github.zh.cn.trio.aop.config.bean.strategy;

import io.github.zh.cn.trio.aop.config.bean.context.BeanNameConfig;
import io.github.zh.cn.trio.aop.croe.context.AopUtilConfig;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;

public class BeanNameConfigStrategy  implements AopStrategy{

	@Override
	public <T extends AopUtilConfig> void operAop(AopUtilContext<T> aopUtilContext, String targetTime) {
		T t=aopUtilContext.getAopUtilConfig();
		BeanNameConfig aopUtilConfig =(BeanNameConfig) t;
	}

	public BeanNameConfig  operAop3(AopUtilContext<BeanNameConfig> aopUtilContext){
		BeanNameConfig beanNameConfig = aopUtilContext.getAopUtilConfig();
		return beanNameConfig;
	}
	
	@Override
	public void operAop1(AopUtilContext<?> aopUtilContext, String targetTime) {
		BeanNameConfig aopUtilConfig = (BeanNameConfig) aopUtilContext.getAopUtilConfig();
	}

	
	

}
