package io.github.zh.cn.trio.aop.croe.utils;

import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.plug.format.bean.FormatBean;

public class FormatConvertUtils {

	public static FormatBean convertContext(AopUtilContext aopUtilContext) {
		FormatBean formatBean = new FormatBean();
		formatBean.setTargetMethod(aopUtilContext.getTargetMethod());
		formatBean.setTargetArgs(aopUtilContext.getTargetArgs());
		formatBean.setTarget(aopUtilContext.getTarget());
		formatBean.setApplicationContext(aopUtilContext.getApplicationContext());
		formatBean.setExtension(aopUtilContext);
		return formatBean;
	}
	
}
