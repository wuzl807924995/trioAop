package io.github.zh.cn.trio.aop.logger.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import io.github.zh.cn.trio.aop.croe.aspect.AbstractAopAspect;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

@Aspect
public class TrioLoggerAnnotationAspect extends AbstractAopAspect {

	@Around("@annotation(io.github.zh.cn.trio.aop.logger.annotation.TrioLogger)")
	public Object proxyAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		return super.proxy(proceedingJoinPoint);
	}

	@Override
	public <T extends AopUtilContext> T initContext(AopUtilContext aopUtilContext) {
		return null;
	}

}
