package io.github.zh.cn.trio.aop.validation.face;

import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.validation.bean.IResult;
import io.github.zh.cn.trio.aop.validation.config.ValidationBeanConfig;

/**
 * 
 * 验证接口
 *
 */
public interface ValidationFace<T extends IResult> {

	T validationData(AopUtilContext<ValidationBeanConfig> aopUtilContext);

	Class<T> getEClass();
}
