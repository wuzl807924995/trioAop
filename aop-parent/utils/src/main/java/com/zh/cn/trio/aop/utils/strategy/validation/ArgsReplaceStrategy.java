package com.zh.cn.trio.aop.utils.strategy.validation;

import com.zh.cn.trio.aop.utils.base.validation.bean.IValidationResult;
import com.zh.cn.trio.aop.utils.base.validation.bean.ValidationResult;
import com.zh.cn.trio.aop.utils.context.AopUtilConfig;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;

/**
 * 参数替换策略 <br/>
 * 		目标方法声明一个 ValidationResult 结果的入参  <br/>
 * 		在ValidationResult.isSuccess()=false的时候将会加载给第一个入参为ValidationResult
 *
 * @param <T>
 */
public abstract class ArgsReplaceStrategy<T extends AopUtilConfig<T>,E extends IValidationResult> extends AbstartValidationResultStrategy<T> {

	public abstract Class<E> getEClass();
	
	@Override
	public void operAop(AopUtilContext<T> aopUtilContext, String targetTime) {
		ValidationResult validationResult = this.validationData(aopUtilContext);
		//验证结果返回失败时
		if (!validationResult.isSuccess()) {
			Class<?>[] classes = aopUtilContext.getTargetArgsClass();
			for (int i = 0; i < classes.length; i++) {
				Class<E> ecls=getEClass();
				//加载替换实参
				if (ecls.equals(classes[i])) {
					Object[] args = aopUtilContext.getTargetArgs();
					args[i] = validationResult;
					aopUtilContext.setTargetArgs(args);
					break;
				}
			}
		}
	}

}
