package io.github.zh.cn.trio.aop.config.bean.context;

import io.github.zh.cn.trio.aop.croe.context.AopUtilConfig;

public class BeanNameConfig extends AopUtilConfig {

	private String beanName;

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	
	
}
