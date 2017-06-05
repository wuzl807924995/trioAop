package io.github.zh.cn.trio.aop.config.bean.name.model;

import io.github.zh.cn.trio.aop.config.bean.name.context.BeanNameContext;

public interface BeanNameModel {

	public void beforeAop(BeanNameContext beanNameContext);

	public void afertAop(BeanNameContext beanNameContext);

	public void errorAop(BeanNameContext beanNameContext);

}
