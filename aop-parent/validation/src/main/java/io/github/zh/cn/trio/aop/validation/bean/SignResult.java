package io.github.zh.cn.trio.aop.validation.bean;

public class SignResult implements IResult {

	@Override
	public boolean isSuccess() {
		return false;
	}

	private String errorCode;

	private String errorMsg;

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
