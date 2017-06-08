package io.github.zh.cn.trio.aop.validation.face.impl;

import io.github.zh.cn.trio.aop.config.abs.context.AbsContext;
import io.github.zh.cn.trio.aop.validation.face.AbstractErrorRetrunValidation;
import io.github.zh.cn.trio.aop.validation.result.IReturnResult;

public class ErrorReturnValidation extends AbstractErrorRetrunValidation {

	@Override
	public <T> IReturnResult<T> validation(AbsContext context) {
		return new IReturnResult<T>() {
			@Override
			public T getErrorResult() {
				return null;
			}

			@Override
			public boolean isSuccess() {
				return true;
			}
		};
	}

}
