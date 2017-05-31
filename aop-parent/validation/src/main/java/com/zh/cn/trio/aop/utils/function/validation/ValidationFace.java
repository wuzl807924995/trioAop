package com.zh.cn.trio.aop.utils.function.validation;

import com.zh.cn.trio.aop.croe.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;
import com.zh.cn.trio.aop.validation.bean.IResult;

/**
 * 
 * 验证接口
 *
 */
public interface ValidationFace<T extends IResult> {

	T validationData(AopUtilContext<ValidationBeanConfig> aopUtilContext);
}
