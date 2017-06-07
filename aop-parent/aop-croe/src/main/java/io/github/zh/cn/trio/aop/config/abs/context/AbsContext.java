package io.github.zh.cn.trio.aop.config.abs.context;

import io.github.zh.cn.trio.aop.config.abs.model.AbsBeanModel;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

public abstract class AbsContext extends AopUtilContext {

	public abstract <T extends AbsBeanModel> T getBeanModel() ;
}
