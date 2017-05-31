package com.zh.cn.trio.aop.croe.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;

import com.zh.cn.trio.aop.croe.context.AopUtilConfig;
import com.zh.cn.trio.aop.croe.context.AopUtilContext;

/**
 * 抽象拦截aop接口
 *
 * @param <T>
 */
public abstract class AbstractAopAspect<T extends AopUtilConfig<T>> implements ApplicationContextAware, Ordered {

	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 容器
	 */
	protected ApplicationContext applicationContext;

	/**
	 * 拦截排序
	 */
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
	 * 拦截aop的模板方法
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	public final Object proxy(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		AopUtilContext<T> aopUtilContext = createContext(proceedingJoinPoint);//初始化配置
		try {
			warpErrorOperAop(aopUtilContext, AopUtilConfig.TIME_BEFORE);//前置通知
			
			Object rs = null;
			if (hasRs(aopUtilContext)) {//如果结果已经设置了，则直接读取结果
				rs = aopUtilContext.getResultObject();
			} else {//没有结果则执行目标方法
				rs = proceedingJoinPoint.proceed(aopUtilContext.getTargetArgs());
				aopUtilContext.setResultObject(rs);
			}

			warpErrorOperAop(aopUtilContext, AopUtilConfig.TIME_AFTER);//后置通知

			return aopUtilContext.getResultObject();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			aopUtilContext.setThrowable(e);
			warpErrorOperAop(aopUtilContext, AopUtilConfig.TIME_ERROR);//异常通知
			throw e;
		}
	}

	/**
	 * 拦截目标的结果值是否已经设置过
	 * @param aopUtilContext
	 * @return
	 */
	protected boolean hasRs(AopUtilContext<?> aopUtilContext) {
		return aopUtilContext != null && aopUtilContext.isSetResult();
	}

	/**
	 * 触发通知
	 * @param aopUtilContext
	 * @param targetTime
	 */
	public void warpErrorOperAop(AopUtilContext<T> aopUtilContext, String targetTime) {
		try {
			aopUtilContext.operAop(targetTime);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 钩子方法  读取配置
	 * @param aopUtilContext
	 * @return
	 */
	public abstract T createBean(AopUtilContext<T> aopUtilContext);

	/**
	 * 创建配置
	 * @param proceedingJoinPoint
	 * @return
	 */
	public AopUtilContext<T> createContext(ProceedingJoinPoint proceedingJoinPoint) {
		try {
			AopUtilContext<T> aopUtilContext = new AopUtilContext<T>();
			MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint = (MethodInvocationProceedingJoinPoint) proceedingJoinPoint;
			T aopUtilConfig = createBean(aopUtilContext);
		
			aopUtilContext.setAopUtilConfig(aopUtilConfig);
			aopUtilContext.setMethodInvocationProceedingJoinPoint(methodInvocationProceedingJoinPoint);
			aopUtilContext.setApplicationContext(getApplicationContext());
			return aopUtilContext;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
}
