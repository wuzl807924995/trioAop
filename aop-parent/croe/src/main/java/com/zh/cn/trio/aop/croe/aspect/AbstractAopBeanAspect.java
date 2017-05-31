package com.zh.cn.trio.aop.croe.aspect;

import com.zh.cn.trio.aop.croe.context.AopUtilConfig;
import com.zh.cn.trio.aop.croe.context.AopUtilContext;

/**
 * 泛型模板配置
 *
 * @param <T>
 */
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
