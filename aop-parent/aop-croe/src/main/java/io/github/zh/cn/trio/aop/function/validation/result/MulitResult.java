package io.github.zh.cn.trio.aop.function.validation.result;

/**
 * 验证结果
 *
 */
public class MulitResult implements IResult {

	/**
	 * 结果是否全部成功
	 */
	private boolean success;

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
	private Object[] validationError;

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

	public Object[] getValidationError() {
		return validationError;
	}

	public void setValidationError(Object[] validationErrorMsg) {
		this.validationError = validationErrorMsg;
	}

}
