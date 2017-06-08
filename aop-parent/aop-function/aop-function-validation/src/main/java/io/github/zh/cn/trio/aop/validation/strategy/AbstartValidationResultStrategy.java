package io.github.zh.cn.trio.aop.validation.strategy;

import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;
import io.github.zh.cn.trio.aop.validation.bean.IResult;
import io.github.zh.cn.trio.aop.validation.config.ValidationBeanConfig;
import io.github.zh.cn.trio.aop.validation.face.ValidationFace;

/**
 * 
 * 验证模板
 * 
 */
public abstract class AbstartValidationResultStrategy<E extends IResult> implements AopStrategy<ValidationBeanConfig> {

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
	 * @return
	 */
	public E validationData(AopUtilContext<ValidationBeanConfig> aopUtilContext) {
		return getValidationFace().validationData(aopUtilContext);
	}

}
