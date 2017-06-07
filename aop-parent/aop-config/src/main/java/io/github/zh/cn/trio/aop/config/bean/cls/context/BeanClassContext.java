package io.github.zh.cn.trio.aop.config.bean.cls.context;

import io.github.zh.cn.trio.aop.config.bean.abs.context.AbsContext;
import io.github.zh.cn.trio.aop.config.bean.abs.model.AbsBeanModel;

public class BeanClassContext extends AbsContext {

	private Class<? extends AbsContext> beanClass;

	public Class<? extends AbsContext> getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Class<? extends AbsContext> beanClass) {
		this.beanClass = beanClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends AbsBeanModel> T getBeanModel() {
		return (T) getApplicationContext().getBean(beanClass);
	}

}
