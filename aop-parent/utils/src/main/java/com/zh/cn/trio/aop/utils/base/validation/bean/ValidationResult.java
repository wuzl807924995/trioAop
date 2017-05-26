package com.zh.cn.trio.aop.utils.base.validation.bean;

/**
 * 验证结果
 *
 */
public class ValidationResult implements IValidationResult{

	/**
	 * 结果是否全部成功
	 */
	private boolean success=true;

	/**
	 * 验证结果
	 */
	private boolean[] validation;
	
	/**
	 * 验证失败返回错误码
	 */
	private String[] validationErrorCode;
	
	/**
	 * 验证出错异常信息
	 */
	private Object[] validationErrorMsg;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean[] getValidation() {
		return validation;
	}

	public void setValidation(boolean[] validation) {
		this.validation = validation;
	}

	public String[] getValidationErrorCode() {
		return validationErrorCode;
	}

	public void setValidationErrorCode(String[] validationErrorCode) {
		this.validationErrorCode = validationErrorCode;
	}

	public Object[] getValidationErrorMsg() {
		return validationErrorMsg;
	}

	public void setValidationErrorMsg(Object[] validationErrorMsg) {
		this.validationErrorMsg = validationErrorMsg;
	}


}
