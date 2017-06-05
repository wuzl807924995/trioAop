package io.github.zh.cn.trio.aop.config.bean.name.context;

import io.github.zh.cn.trio.aop.config.bean.name.model.BeanNameModel;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

public class BeanNameContext extends AopUtilContext {

	private String beanName;

	public <T extends BeanNameModel> BeanNameModel getBeanModel() {
		return getApplicationContext().getBean(beanName, BeanNameModel.class);
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

}
