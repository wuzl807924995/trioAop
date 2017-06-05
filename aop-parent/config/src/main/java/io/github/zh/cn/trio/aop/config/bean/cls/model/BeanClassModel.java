package io.github.zh.cn.trio.aop.config.bean.cls.model;

import io.github.zh.cn.trio.aop.config.bean.cls.context.BeanClassConfig;

public interface BeanClassModel {

	public void beforeAop(BeanClassConfig beanClassConfig);

	public void afertAop(BeanClassConfig beanClassConfig);

	public void errorAop(BeanClassConfig beanClassConfig);
}
