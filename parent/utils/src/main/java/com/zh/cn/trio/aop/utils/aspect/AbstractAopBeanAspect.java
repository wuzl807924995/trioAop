package com.zh.cn.trio.aop.utils.aspect;

import com.zh.cn.trio.aop.utils.context.AopUtilConfig;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;

public class AbstractAopBeanAspect<T extends AopUtilConfig<T>> extends AbstractAopAspect<T> {

	private T configBean;

	public T getConfigBean() {
		return configBean;
	}

	public void setConfigBean(T configBean) {
		this.configBean = configBean;
	}

	@Override
	public T createBean(AopUtilContext<T> aopUtilContext) {
		return configBean;
	}

}
