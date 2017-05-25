package com.zh.cn.trio.aop.utils.function.validation;

import com.zh.cn.trio.aop.utils.base.validation.bean.ValidationResult;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;

/**
 * 
 * 验证接口
 *
 */
public interface ValidationFace {

	ValidationResult validationData(AopUtilContext<ValidationBeanConfig> aopUtilContext);
}
