package io.github.zh.cn.trio.aop.config.abs.context;

import io.github.zh.cn.trio.aop.config.abs.model.AbsBeanModel;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.plug.format.Format;

public abstract class AbsContext extends AopUtilContext {

	private Format format;

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public abstract <T extends AbsBeanModel> T getBeanModel();
}
