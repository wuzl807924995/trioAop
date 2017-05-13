package com.zh.cn.trio.aop.utils.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;

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

	/**
	 * 
	 * @param proceedingJoinPoint
	 * @return
	 */
	public Method getTargetMethod(ProceedingJoinPoint proceedingJoinPoint) {
		MethodSignature joinPointObject = (MethodSignature) proceedingJoinPoint.getSignature();
		Method method = joinPointObject.getMethod();
		return method;
	}

	public Object proxy(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		AopUtilContext<T> aopUtilContext = createContext(proceedingJoinPoint);
		try {
			warpErrorOperAop(aopUtilContext, AopUtilConfig.TIME_BEFORE);
			Object rs = null;
			if (runAround(aopUtilContext)) {
				rs = aopUtilContext.getResultObject();
			} else {
				rs = proceedingJoinPoint.proceed();
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

	protected boolean runAround(AopUtilContext<?> aopUtilContext) {
		return aopUtilContext != null && aopUtilContext.getAopUtilConfig() != null
				&& aopUtilContext.getAopUtilConfig().isAround();
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
			Method method = getTargetMethod(proceedingJoinPoint);
			Object[] args = proceedingJoinPoint.getArgs();
			T aopUtilConfig = createBean(aopUtilContext);

			aopUtilContext.setTargetMethod(method);
			aopUtilContext.setTargetArgs(args);
			aopUtilContext.setAopUtilConfig(aopUtilConfig);
			aopUtilContext.setProceedingJoinPoint(proceedingJoinPoint);

			return aopUtilContext;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
}
