package com.zh.cn.trio.aop.utils.strategy.validation;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.zh.cn.trio.aop.utils.base.format.Format;
import com.zh.cn.trio.aop.utils.base.format.utils.FormatBean;
import com.zh.cn.trio.aop.utils.base.format.utils.FormatConvertUtils;
import com.zh.cn.trio.aop.utils.base.validation.bean.ValidationResult;
import com.zh.cn.trio.aop.utils.context.AopUtilConfig;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;

/**
 * 错误返回策略<br/>
 *	在ValidationResult.isSuccess()=false的时候将会返回解析到的返回信息
 * @param <T>
 */
public abstract class ErrorReturnStrategy<T extends AopUtilConfig<T>> extends AbstartValidationResultStrategy<T> implements ApplicationContextAware{

	public abstract String getErrorMsgFormatString(AopUtilContext<T> aopUtilContext);
	
	protected ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
	
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	
	@Override
	public void operAop(AopUtilContext<T> aopUtilContext, String targetTime) {
		ValidationResult validationResult = this.validationData(aopUtilContext);
		if (!validationResult.isSuccess()) {
			Object msg=this.getErrorMsgFormatString(aopUtilContext);
			FormatBean formatBean = FormatConvertUtils.convertContext(aopUtilContext,msg);
			Format format = aopUtilContext.getAopUtilConfig().getFormat();
			Object object = format.format(formatBean,applicationContext,this.getErrorMsgFormatString(aopUtilContext));
			aopUtilContext.setResultObject(object);
		}		
	}


}
