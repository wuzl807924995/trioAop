package io.github.zh.cn.trio.aop.validation.result;

public class SimpleReturnResult<T> implements IReturnResult<T> {

	private boolean  success;
	
	private T errorResult;
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	@Override
	public boolean isSuccess() {
		return success;
	}

	@Override
	public T getErrorResult() {
		return errorResult;
	}
	
	public void setErrorResult(T errorResult) {
		this.errorResult = errorResult;
	}

}
