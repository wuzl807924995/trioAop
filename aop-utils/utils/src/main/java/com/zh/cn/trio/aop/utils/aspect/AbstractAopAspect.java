package com.zh.cn.trio.aop.utils.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.zh.cn.trio.aop.utils.bean.AopUtilBean;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.format.Format;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

public abstract class AbstractAopAspect<T> implements ApplicationContextAware {
	private Logger logger = LoggerFactory.getLogger(getClass());

	protected ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	/**
	 * 提取目标方法
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
			warpErrorOperAop(aopUtilContext, AopUtilBean.TIME_BEFORE);
			Object rs = proceedingJoinPoint.proceed();

			if (aopUtilContext != null) {
				aopUtilContext.setResultObject(rs);
			}
			warpErrorOperAop(aopUtilContext, AopUtilBean.TIME_AFTER);

			return aopUtilContext.getResultObject();
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			warpErrorOperAop(aopUtilContext, AopUtilBean.TIME_ERROR);
			throw e;
		}
	}

	public void warpErrorOperAop(AopUtilContext<T> aopUtilContext, String targetTime) {
		try {
			aopUtilContext.operAop(targetTime);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public abstract AopUtilBean<T> createBean(ProceedingJoinPoint proceedingJoinPoint,
			AopUtilContext<T> aopUtilContext);

	public  AopUtilContext<T> createContext(ProceedingJoinPoint proceedingJoinPoint) {
		try {
			AopUtilContext<T> aopUtilContext = new AopUtilContext<T>();
			Method method = getTargetMethod(proceedingJoinPoint);
			Object[] args = proceedingJoinPoint.getArgs();
			AopUtilBean<T> aopUtilBean = createBean(proceedingJoinPoint, aopUtilContext);
			AopStrategy aopStrategy = applicationContext.getBean(aopUtilBean.getStrategy(), AopStrategy.class);
			Format format = applicationContext.getBean(aopUtilBean.getFormatModel(),Format.class);

			aopUtilContext.setTargetMethod(method);
			aopUtilContext.setTargetArgs(args);
			aopUtilContext.setAopUtilBean(aopUtilBean);
			aopUtilContext.setAopStrategy(aopStrategy);
			aopUtilContext.setFormat(format);
			
			return aopUtilContext;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
}
