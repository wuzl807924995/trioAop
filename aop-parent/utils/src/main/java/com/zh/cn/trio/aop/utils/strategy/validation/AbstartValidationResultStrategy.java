package com.zh.cn.trio.aop.utils.strategy.validation;

import com.zh.cn.trio.aop.utils.base.validation.bean.IValidationResult;
import com.zh.cn.trio.aop.utils.context.AopUtilConfig;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

/**
 * 
 * 验证模板
 * 
 * @param <T>
 */
public abstract class AbstartValidationResultStrategy<T extends AopUtilConfig<T>> implements AopStrategy<T> {

	/***
	 * 验证结果
	 * 
	 * @param aopUtilContext
	 * @return
	 */
	public abstract IValidationResult validationData(AopUtilContext<T> aopUtilContext);
}
