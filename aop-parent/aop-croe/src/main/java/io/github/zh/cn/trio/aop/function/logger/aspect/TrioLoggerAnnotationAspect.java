package io.github.zh.cn.trio.aop.function.logger.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

import io.github.zh.cn.trio.aop.croe.aspect.AbstractAopAspect;
import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.logger.annotation.TrioLogger;

@Aspect
public class TrioLoggerAnnotationAspect extends AbstractAopAspect {

	@Around("@annotation(io.github.zh.cn.trio.aop.function.logger.annotation.TrioLogger)")
	public Object proxyAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		return super.proxy(proceedingJoinPoint);
	}

	@Override
	public RunTimeConfig initConfig(RunTimeContext runTimeContext) {
		// TODO Auto-generated method stub
		TrioLogger trioLogger = runTimeContext.getAnnotation(TrioLogger.class);

		return null;
	}

}
