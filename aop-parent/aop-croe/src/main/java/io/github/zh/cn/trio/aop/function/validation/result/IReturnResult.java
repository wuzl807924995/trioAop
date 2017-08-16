package io.github.zh.cn.trio.aop.function.validation.result;

public interface IReturnResult<T> extends IResult {
	
	T getErrorResult();
}
