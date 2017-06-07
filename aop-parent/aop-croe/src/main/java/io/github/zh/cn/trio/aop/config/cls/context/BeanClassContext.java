package io.github.zh.cn.trio.aop.config.cls.context;

import io.github.zh.cn.trio.aop.config.abs.context.AbsContext;
import io.github.zh.cn.trio.aop.config.abs.model.AbsBeanModel;

public class BeanClassContext extends AbsContext {

	private Class<? extends AbsBeanModel> beanClass;

	public Class<? extends AbsBeanModel> getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Class<? extends AbsBeanModel> beanClass) {
		this.beanClass = beanClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends AbsBeanModel> T getBeanModel() {
		return (T) getApplicationContext().getBean(beanClass);
	}

}
