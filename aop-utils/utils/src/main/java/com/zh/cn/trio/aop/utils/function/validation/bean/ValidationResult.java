package com.zh.cn.trio.aop.utils.function.validation.bean;

public class ValidationResult {

	private boolean success=true;

	private boolean[] validation;

	private String[] validationErrorMsg;

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

	public String[] getValidationErrorMsg() {
		return validationErrorMsg;
	}

	public void setValidationErrorMsg(String[] validationErrorMsg) {
		this.validationErrorMsg = validationErrorMsg;
	}

}
