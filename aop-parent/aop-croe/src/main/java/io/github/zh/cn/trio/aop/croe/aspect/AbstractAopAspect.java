package io.github.zh.cn.trio.aop.croe.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;

import io.github.zh.cn.trio.aop.croe.adapter.RunTimeAdapter;
import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;

/**
 * 抽象拦截aop接口
 *
 */
public abstract class AbstractAopAspect implements ApplicationContextAware, Ordered {

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
		RunTimeContext runTimeContext = null;
		RunTimeConfig runTimeConfig = null;
		// init
		try {
			runTimeContext = initContext(proceedingJoinPoint);
			runTimeConfig = initConfig(runTimeContext);
		} catch (Exception e) {
			logger.error("init context and config has a error ", e);
			runTimeContext = null;
			runTimeConfig = null;
		}

		// doing
		try {
			// check
			if (runTimeContext == null || runTimeConfig == null) {
				return proceedingJoinPoint.proceed();
			}
			warpErrorOperAop(runTimeContext, runTimeConfig, RunTimeConfig.TIME_BEFORE);

			// check result set
			if (runTimeContext.isSetResult()) {
				return runTimeContext.getResultObject();
			} else {
				warpErrorOperAop(runTimeContext, runTimeConfig, RunTimeConfig.TIME_AROUND_STARAT);
				Object rs = proceedingJoinPoint.proceed(runTimeContext.getTargetArgs());// invoke method
				warpErrorOperAop(runTimeContext, runTimeConfig, RunTimeConfig.TIME_AROUND_END);

				runTimeContext.setResultObject(rs);
				warpErrorOperAop(runTimeContext, runTimeConfig, RunTimeConfig.TIME_AFTER);

				return runTimeContext.getResultObject();
			}
		} catch (Exception e) {
			if (runTimeContext != null && runTimeConfig != null) {
				runTimeContext.setThrowable(e);
				warpErrorOperAop(runTimeContext, runTimeConfig, RunTimeConfig.TIME_BEFORE);
			}
			throw e;
		}
	}

	/**
	 * 根据配置和上下文以及触发时间执行目标适配器
	 * @param runTimeContext 上下文
	 * @param runTimeConfig 配置
	 * @param targetTime 触发时间
	 */
	public void warpErrorOperAop(RunTimeContext runTimeContext, RunTimeConfig runTimeConfig, String targetTime) {
		try {
			boolean enable = runTimeConfig.checkEnable(targetTime);
			if (enable) {
				RunTimeAdapter runTimeAdapter = runTimeConfig.getRunTimeAdapter();
				runTimeAdapter.adapterTo(runTimeContext, runTimeConfig, targetTime);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 
	 * @param runTimeContext 上下文环境
	 * @return 得到上下文配置
	 */
	public abstract RunTimeConfig initConfig(RunTimeContext runTimeContext);

	/**
	 * 
	 * @param proceedingJoinPoint 拦截点
	 * @return 得到上下文环境
	 */
	protected RunTimeContext initContext(ProceedingJoinPoint proceedingJoinPoint) {
		RunTimeContext runTimeContext = new RunTimeContext(proceedingJoinPoint, this.getApplicationContext());
		return runTimeContext;
	}
}
