package io.github.zh.cn.trio.aop.croe.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;

import io.github.zh.cn.trio.aop.croe.context.AopUtilConfig;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

/**
 * 抽象拦截aop接口
 *
 * @param <T> 配置子类
 */
public abstract class AbstractAopAspect<T extends AopUtilConfig> implements ApplicationContextAware, Ordered {

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
	 * @param proceedingJoinPoint 拦截点 @see MethodInvocationProceedingJoinPoint
	 * @return 目标方法返回值
	 * @throws Throwable 目标方法异常
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
	 * @param aopUtilContext 配置上下文
	 * @return 是否已经设置过返回值
	 */
	protected boolean hasRs(AopUtilContext<?> aopUtilContext) {
		return aopUtilContext != null && aopUtilContext.isSetResult();
	}

	/**
	 * 触发通知
	 * @param aopUtilContext 配置上下文
	 * @param targetTime 触发时间
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
	 * @param aopUtilContext 上下文
	 * @return 子类化配置
	 */
	public abstract T createBean(AopUtilContext<T> aopUtilContext);

	/**
	 * 创建配置
	 * @param proceedingJoinPoint 切面
	 * @return 上下文
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
