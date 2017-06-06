package io.github.zh.cn.trio.aop.config.bean.name.context;

import io.github.zh.cn.trio.aop.config.bean.abs.context.AbsContext;
import io.github.zh.cn.trio.aop.config.bean.abs.model.AbsBeanModel;

public class BeanNameContext extends AbsContext {

	private String beanName;

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends AbsBeanModel> T getBeanModel() {
		return (T) getApplicationContext().getBean(beanName, AbsBeanModel.class);
	}

}
