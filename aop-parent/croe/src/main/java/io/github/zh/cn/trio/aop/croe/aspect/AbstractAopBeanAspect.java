package io.github.zh.cn.trio.aop.croe.aspect;

import io.github.zh.cn.trio.aop.croe.context.AopUtilConfig;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

/**
 * 泛型模板配置
 *
 * @param <T> 子类配置
 */
public class AbstractAopBeanAspect<T extends AopUtilConfig> extends AbstractAopAspect<T> {

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
