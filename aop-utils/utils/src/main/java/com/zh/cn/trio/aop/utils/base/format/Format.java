package com.zh.cn.trio.aop.utils.base.format;

import com.zh.cn.trio.aop.utils.aspect.AopUtilConfig;
import com.zh.cn.trio.aop.utils.aspect.AopUtilContext;

public interface Format {

	Object formatContext(AopUtilContext<? extends AopUtilConfig<?>> aopContext);

	String formatContextToString(AopUtilContext<? extends AopUtilConfig<?>> aopContext);
}
