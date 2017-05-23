package com.zh.cn.trio.aop.utils.strategy.validation;

import com.zh.cn.trio.aop.utils.base.validation.bean.ValidationResult;
import com.zh.cn.trio.aop.utils.context.AopUtilConfig;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

public abstract class AbstartValidationResultStrategy<T extends AopUtilConfig<T>> implements AopStrategy<T>{
	
	public abstract ValidationResult validationData(AopUtilContext<T> aopUtilContext);
}
