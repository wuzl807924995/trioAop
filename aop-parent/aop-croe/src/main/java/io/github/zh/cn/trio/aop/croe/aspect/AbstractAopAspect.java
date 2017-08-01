package io.github.zh.cn.trio.aop.croe.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;

import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;

/**
 * 抽象拦截aop接口
 *
 * 配置子类
 */
public abstract class AbstractAopAspect<T extends AopUtilContext> implements ApplicationContextAware, Ordered {

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
	 * 
	 * @param proceedingJoinPoint
	 *            拦截点 @see MethodInvocationProceedingJoinPoint
	 * @return 目标方法返回值
	 * @throws Throwable
	 *             目标方法异常
	 */
	public final Object proxy(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		AopUtilContext aopUtilContext = null;// 初始化配置
		try {
			aopUtilContext = createContext(proceedingJoinPoint);// 初始化配置
			if (aopUtilContext == null) {
				// 上下文初始化失败 直接不拦截执行
				return proceedingJoinPoint.proceed();
			}
			warpErrorOperAop(aopUtilContext, AopUtilContext.TIME_BEFORE);// 前置通知

			// 前置时间
			aopUtilContext.setAroundTimeStarat(System.currentTimeMillis()); 
			Object rs = null;
			if (hasRs(aopUtilContext)) {// 如果结果已经设置了，则直接读取结果
				rs = aopUtilContext.getResultObject();
			} else {// 没有结果则执行目标方法
				Object[] args = aopUtilContext.getTargetArgs();
				rs = proceedingJoinPoint.proceed(args);
				aopUtilContext.setResultObject(rs);
			}
			// 后置时间
			aopUtilContext.setAroundTimeEnd(System.currentTimeMillis());

			warpErrorOperAop(aopUtilContext, AopUtilContext.TIME_AFTER);// 后置通知

			return aopUtilContext.getResultObject();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			try {
				if (aopUtilContext != null) {
					aopUtilContext.setThrowable(e);
					warpErrorOperAop(aopUtilContext, AopUtilContext.TIME_ERROR);// 异常通知
				}
			} catch (Exception e2) {
				logger.error("aop around erorr has error", e2);
			}
			throw e;
		}
	}

	/**
	 * 拦截目标的结果值是否已经设置过
	 * 
	 * @param aopUtilContext
	 *            配置上下文
	 * @return 是否已经设置过返回值
	 */
	protected boolean hasRs(AopUtilContext aopUtilContext) {
		return aopUtilContext != null && aopUtilContext.isSetResult();
	}

	/**
	 * 触发通知
	 * 
	 * @param aopUtilContext
	 *            配置上下文
	 * @param targetTime
	 *            触发时间
	 */
	public void warpErrorOperAop(AopUtilContext aopUtilContext, String targetTime) {
		try {
			boolean enable = aopUtilContext.checkEnable(targetTime);
			if (enable) {
				AopStrategy aopStrategy = aopUtilContext.getAopStrategy();
				aopStrategy.operAop(aopUtilContext, targetTime);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 创建配置
	 * 
	 * @param proceedingJoinPoint
	 *            切面
	 * @return 上下文
	 */
	public T createContext(ProceedingJoinPoint proceedingJoinPoint) {
		try {
			MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint = (MethodInvocationProceedingJoinPoint) proceedingJoinPoint;
			return initContext(methodInvocationProceedingJoinPoint);
		} catch (Exception e) {
			logger.error("create contet has a exception", e);
			return null;
		}
	}

	public abstract T initContext(MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint);

}
