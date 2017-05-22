package com.zh.cn.trio.aop.utils.function.validation.strategy;

import com.zh.cn.trio.aop.utils.base.format.Format;
import com.zh.cn.trio.aop.utils.base.format.utils.FormatBean;
import com.zh.cn.trio.aop.utils.base.format.utils.FormatConvertUtils;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.validation.ValidationFace;
import com.zh.cn.trio.aop.utils.function.validation.bean.ValidationResult;
import com.zh.cn.trio.aop.utils.function.validation.config.ValidationBeanConfig;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

public class ErrorReturnValidationStrategy implements AopStrategy<ValidationBeanConfig>{

	@Override
	public void operAop(AopUtilContext<ValidationBeanConfig> aopUtilContext, String targetTime) {
		ValidationFace validationFace = aopUtilContext.getAopUtilConfig().getValidationFace();
		ValidationResult validationResult = validationFace.validationData(aopUtilContext);
		if (!validationResult.isSuccess()) {
			Object msg=aopUtilContext.getAopUtilConfig().getValidationErrorMsg();
			FormatBean formatBean = FormatConvertUtils.convertContext(aopUtilContext,msg);
			Format format = aopUtilContext.getAopUtilConfig().getFormat();
			Object object = format.format(formatBean, aopUtilContext.getAopUtilConfig().getValidationErrorResult());
			aopUtilContext.setResultObject(object);
		}
	}

}
