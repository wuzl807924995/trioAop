package io.github.zh.cn.trio.aop.config.bean.cls.model;

import io.github.zh.cn.trio.aop.config.bean.cls.context.BeanClassContext;

public interface BeanClassModel {

	public void beforeAop(BeanClassContext beanClassContext);

	public void afertAop(BeanClassContext beanClassContext);

	public void errorAop(BeanClassContext beanClassContext);
}
