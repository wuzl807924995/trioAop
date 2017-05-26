package com.zh.cn.trio.aop.utils.strategy.validation;

import com.zh.cn.trio.aop.utils.base.validation.bean.IValidationResult;
import com.zh.cn.trio.aop.utils.context.AopUtilConfig;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.validation.ValidationFace;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

/**
 * 
 * 验证模板
 * 
 * @param <T>
 */
public abstract class AbstartValidationResultStrategy<T extends AopUtilConfig<T>,E extends IValidationResult> implements AopStrategy<T> {


	/**
	 * 验证接口
	 */
	private ValidationFace<E> validationFace;

	public ValidationFace<E> getValidationFace() {
		return validationFace;
	}
	
	public void setValidationFace(ValidationFace<E> validationFace) {
		this.validationFace = validationFace;
	}
	
	/***
	 * 验证结果
	 * 
	 * @param aopUtilContext
	 * @return
	 */
	public abstract IValidationResult validationData(AopUtilContext<T> aopUtilContext);
}
