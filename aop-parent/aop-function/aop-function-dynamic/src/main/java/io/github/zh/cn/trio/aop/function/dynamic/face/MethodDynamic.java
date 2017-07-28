package io.github.zh.cn.trio.aop.function.dynamic.face;

import io.github.zh.cn.trio.aop.croe.utils.FormatConvertUtils;
import io.github.zh.cn.trio.aop.function.dynamic.context.DynamicContext;
import io.github.zh.cn.trio.aop.plug.format.Format;

public abstract class MethodDynamic implements DynamicFace {

	private static final String spel = "getTarget().getClass().getName()+getTargetMethod().getName()";

	private Format format;

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public String getMethodName(DynamicContext dynamicContext) {
		return format.format(FormatConvertUtils.convertContext(dynamicContext), spel);
	}

}
