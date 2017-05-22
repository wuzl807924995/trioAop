package com.zh.cn.trio.aop.utils.base.format.utils;

import com.zh.cn.trio.aop.utils.context.AopUtilContext;

public class FormatConvertUtils {

	public static FormatBean convertContext(AopUtilContext<?> aopUtilContext) {
		FormatBean formatBean = new FormatBean();
		formatBean.setTargetMethod(aopUtilContext.getTargetMethod());
		formatBean.setTargetArgs(aopUtilContext.getTargetArgs());
		formatBean.setTarget(aopUtilContext.getTarget());
		return formatBean;
	}
}
