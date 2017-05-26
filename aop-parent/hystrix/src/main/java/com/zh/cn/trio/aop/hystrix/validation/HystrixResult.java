package com.zh.cn.trio.aop.hystrix.validation;

import com.zh.cn.trio.aop.utils.base.validation.bean.IValidationResult;

public class HystrixResult implements IValidationResult {

	private boolean success;

	private String errorCode;

	private String errorMsg;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
