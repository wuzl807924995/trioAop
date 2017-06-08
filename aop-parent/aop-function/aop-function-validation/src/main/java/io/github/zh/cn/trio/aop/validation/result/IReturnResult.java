package io.github.zh.cn.trio.aop.validation.result;

public interface IReturnResult<T> extends IResult {
	
	T getErrorResult();
}
