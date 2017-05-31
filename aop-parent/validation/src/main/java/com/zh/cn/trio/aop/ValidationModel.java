package com.zh.cn.trio.aop;

import com.zh.cn.trio.aop.croe.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;
import com.zh.cn.trio.aop.validation.bean.SignResult;

public interface ValidationModel {

	SignResult validationData(AopUtilContext<ValidationBeanConfig> aopUtilContext);
}
