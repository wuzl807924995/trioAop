package io.github.zh.cn.trio.aop.config.bean.name.model;

import io.github.zh.cn.trio.aop.config.bean.name.context.BeanNameConfig;

public interface BeanNameModel {

	public void beforeAop(BeanNameConfig beanNameConfig);

	public void afertAop(BeanNameConfig beanNameConfig);

	public void errorAop(BeanNameConfig beanNameConfig);

}
