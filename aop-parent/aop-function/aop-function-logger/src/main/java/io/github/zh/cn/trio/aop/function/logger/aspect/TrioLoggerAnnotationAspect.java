package io.github.zh.cn.trio.aop.function.logger.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;
import io.github.zh.cn.trio.aop.croe.utils.BeanUtils;
import io.github.zh.cn.trio.aop.function.logger.annotation.TrioLogger;
import io.github.zh.cn.trio.aop.function.logger.config.TrioLoggerConfig;
import io.github.zh.cn.trio.aop.function.logger.context.LoggerBeanContext;
import io.github.zh.cn.trio.aop.function.logger.face.LoggerFace;

@Aspect
public class TrioLoggerAnnotationAspect extends AbstractTrioLoggerAspect {

	@Around("@annotation(io.github.zh.cn.trio.aop.function.logger.annotation.TrioLogger)")
	public Object proxyAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		return super.proxy(proceedingJoinPoint);
	}

	@Override
	public LoggerBeanContext initContext(MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint) {
		LoggerBeanContext loggerBeanContext = new LoggerBeanContext();
		loggerBeanContext.setMethodInvocationProceedingJoinPoint(methodInvocationProceedingJoinPoint);
		loggerBeanContext.setApplicationContext(getApplicationContext());

		TrioLogger trioLogger = loggerBeanContext.getTargetMethod().getAnnotation(TrioLogger.class);
		LoggerFace loggerFace = BeanUtils.getBean(getApplicationContext(), trioLogger.loggerFace(), LoggerFace.class,
				getDefaultLoggerFace());
		AopStrategy aopStrategy = BeanUtils.getBean(getApplicationContext(), trioLogger.aopStrategy(),
				AopStrategy.class, getDefaultLoggerStrategy());

		String targetName = getTargetName(loggerBeanContext, trioLogger.targetName());
		String modelString = getModelString(trioLogger.modelString());
		TrioLoggerConfig trioLoggerConfig = new TrioLoggerConfig(trioLogger.targetTime(), trioLogger.targetLevel(),
				targetName, modelString);

		loggerBeanContext.setAopStrategy(aopStrategy);
		loggerBeanContext.setTargetTimes(new String[] { trioLogger.targetTime() });
		loggerBeanContext.setLoggerFace(loggerFace);
		loggerBeanContext.setTrioLoggerConfig(trioLoggerConfig);
		return loggerBeanContext;
	}

}
