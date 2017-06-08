package io.github.zh.cn.trio.aop.validation.face;

import io.github.zh.cn.trio.aop.config.abs.context.AbsContext;
import io.github.zh.cn.trio.aop.validation.result.IReturnResult;

public abstract class AbstractArgsRepleseValidation<T> extends AbstractValidationFace {

	@Override
	public void beforeAop(AbsContext context) {
		IReturnResult<T> iReturnResult = validation(context);
		if (!iReturnResult.isSuccess()) {
			Object[] objects = context.getTargetArgs();
			if (objects != null && objects.length != 0) {
				for (int i = 0; i < objects.length; i++) {
					if (objects[i] != null && iReturnResult.getClass().equals(objects[i].getClass())) {
						objects[i] = iReturnResult;
					}
				}
			}

		}
	}

}
