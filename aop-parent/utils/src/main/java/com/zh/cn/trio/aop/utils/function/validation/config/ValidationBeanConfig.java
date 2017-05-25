package com.zh.cn.trio.aop.utils.function.validation.config;

import com.zh.cn.trio.aop.utils.context.AopUtilConfig;
import com.zh.cn.trio.aop.utils.function.validation.ValidationFace;

/**
 *	 
 *	验证模式配置
 */
public class ValidationBeanConfig extends AopUtilConfig<ValidationBeanConfig>  {

	/**
	 * 验证集合
	 */
	private String[] validationExpression;

	/**
	 * 验证失败错误信息
	 */
	private String[] validationErrorMsg;
	
	/**
	 * 验证失败返回信息
	 */
	private String validationErrorResult;

	/**
	 * 验证接口
	 */
	private ValidationFace validationFace;

	public String[] getValidationExpression() {
		return validationExpression;
	}

	public void setValidationExpression(String[] validationExpression) {
		this.validationExpression = validationExpression;
	}

	public String[] getValidationErrorMsg() {
		return validationErrorMsg;
	}

	public void setValidationErrorMsg(String[] validationErrorMsg) {
		this.validationErrorMsg = validationErrorMsg;
	}

	public String getValidationErrorResult() {
		return validationErrorResult;
	}

	public void setValidationErrorResult(String validationErrorResult) {
		this.validationErrorResult = validationErrorResult;
	}

	public ValidationFace getValidationFace() {
		return validationFace;
	}

	public void setValidationFace(ValidationFace validationFace) {
		this.validationFace = validationFace;
	}


}
