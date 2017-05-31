package com.zh.cn.trio.aop.utils.function.validation.strategy;

import com.zh.cn.trio.aop.croe.context.AopUtilConfig;
import com.zh.cn.trio.aop.croe.context.AopUtilContext;
import com.zh.cn.trio.aop.croe.strategy.AopStrategy;
import com.zh.cn.trio.aop.utils.function.validation.ValidationFace;
import com.zh.cn.trio.aop.validation.bean.IResult;

/**
 * 
 * 验证模板
 * 
 * @param <T>
 */
public abstract class AbstartValidationResultStrategy<T extends AopUtilConfig<T>, E extends IResult>
		implements AopStrategy<T> {

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
	public abstract E validationData(AopUtilContext<T> aopUtilContext);
}
