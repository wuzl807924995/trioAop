package com.zh.cn.trio.aop.utils.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;

import com.zh.cn.trio.aop.utils.context.AopUtilConfig;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;

public abstract class AbstractAopAspect<T extends AopUtilConfig<T>> implements ApplicationContextAware, Ordered {

	private Logger logger = LoggerFactory.getLogger(getClass());

	protected ApplicationContext applicationContext;

	protected int order;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public Object proxy(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		AopUtilContext<T> aopUtilContext = createContext(proceedingJoinPoint);
		try {
			warpErrorOperAop(aopUtilContext, AopUtilConfig.TIME_BEFORE);
			Object rs = null;
			if (hasRs(aopUtilContext)) {
				rs = aopUtilContext.getResultObject();
			} else {
				rs = proceedingJoinPoint.proceed(aopUtilContext.getTargetArgs());
				aopUtilContext.setResultObject(rs);
			}

			warpErrorOperAop(aopUtilContext, AopUtilConfig.TIME_AFTER);

			return aopUtilContext.getResultObject();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			aopUtilContext.setThrowable(e);
			warpErrorOperAop(aopUtilContext, AopUtilConfig.TIME_ERROR);
			throw e;
		}
	}

	protected boolean hasRs(AopUtilContext<?> aopUtilContext) {
		return aopUtilContext != null && aopUtilContext.isSetResult();
	}

	public void warpErrorOperAop(AopUtilContext<T> aopUtilContext, String targetTime) {
		try {
			aopUtilContext.operAop(targetTime);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public abstract T createBean(AopUtilContext<T> aopUtilContext);

	public AopUtilContext<T> createContext(ProceedingJoinPoint proceedingJoinPoint) {
		try {
			AopUtilContext<T> aopUtilContext = new AopUtilContext<T>();
			MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint = (MethodInvocationProceedingJoinPoint) proceedingJoinPoint;
			T aopUtilConfig = createBean(aopUtilContext);
			aopUtilContext.setAopUtilConfig(aopUtilConfig);
			aopUtilContext.setMethodInvocationProceedingJoinPoint(methodInvocationProceedingJoinPoint);
			return aopUtilContext;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
}
