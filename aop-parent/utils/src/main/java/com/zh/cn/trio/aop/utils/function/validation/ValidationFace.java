package com.zh.cn.trio.aop.utils.function.validation;

import com.zh.cn.trio.aop.utils.base.validation.bean.IValidationResult;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;

/**
 * 
 * 验证接口
 *
 */
public interface ValidationFace<T extends IValidationResult> {

	T validationData(AopUtilContext<ValidationBeanConfig> aopUtilContext);
}
