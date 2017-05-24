package com.zh.cn.trio.aop.utils.function.auth.spel;

import com.zh.cn.trio.aop.utils.base.format.Format;
import com.zh.cn.trio.aop.utils.base.format.utils.FormatBean;
import com.zh.cn.trio.aop.utils.base.format.utils.FormatConvertUtils;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.auth.AuthFace;
import com.zh.cn.trio.aop.utils.function.auth.config.AuthBeanConfig;

public class SpelAuthFaceImpl implements AuthFace {

	@Override
	public boolean auth(AopUtilContext<AuthBeanConfig> aopUtilContext) {
		Format format = aopUtilContext.getAopUtilConfig().getFormat();
		FormatBean formatBean = FormatConvertUtils.convertContext(aopUtilContext);
		String expressionString = aopUtilContext.getAopUtilConfig().getFormatString();
		return format.format(formatBean, expressionString);
	}

}
