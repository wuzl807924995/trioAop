package io.github.zh.cn.trio.aop.croe.utils;

import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.utils.format.bean.FormatBean;

public class FormatConvertUtils {

	public static FormatBean convertContext(AopUtilContext aopUtilContext) {
		FormatBean formatBean = new FormatBean();
		formatBean.setTargetMethod(aopUtilContext.getTargetMethod());
		formatBean.setTargetArgs(aopUtilContext.getTargetArgs());
		formatBean.setTarget(aopUtilContext.getTarget());
		formatBean.setApplicationContext(aopUtilContext.getApplicationContext());
		return formatBean;
	}
	
	public static FormatBean convertContext(AopUtilContext aopUtilContext,Object... extension) {
		FormatBean formatBean = convertContext(aopUtilContext);
		formatBean.setExtension(extension);
		return formatBean;
	}
}
