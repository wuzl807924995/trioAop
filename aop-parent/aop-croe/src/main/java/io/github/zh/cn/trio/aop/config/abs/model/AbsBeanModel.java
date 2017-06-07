package io.github.zh.cn.trio.aop.config.abs.model;

import io.github.zh.cn.trio.aop.config.abs.context.AbsContext;

public interface AbsBeanModel {

	public void beforeAop(AbsContext context);

	public void afertAop(AbsContext context);

	public void errorAop(AbsContext context);
}
