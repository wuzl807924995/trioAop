package io.github.zh.cn.trio.aop.validation.model;

import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.validation.bean.IResult;
import io.github.zh.cn.trio.aop.validation.config.ValidationBeanConfig;

public interface ValidationModel {

	<T extends IResult> T validationData(AopUtilContext<ValidationBeanConfig> aopUtilContext);
}
