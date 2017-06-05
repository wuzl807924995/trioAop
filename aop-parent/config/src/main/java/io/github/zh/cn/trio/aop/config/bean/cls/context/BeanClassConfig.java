package io.github.zh.cn.trio.aop.config.bean.cls.context;

import io.github.zh.cn.trio.aop.config.bean.cls.model.BeanClassModel;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

public class BeanClassConfig extends AopUtilContext {

	private Class<? extends BeanClassModel> beanClass;

	public Class<? extends BeanClassModel> getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Class<? extends BeanClassModel> beanClass) {
		this.beanClass = beanClass;
	}

	public <T extends BeanClassModel> BeanClassModel getBeanModel() {
		return getApplicationContext().getBean(getBeanClass());
	}
}
