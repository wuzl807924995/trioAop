package io.github.zh.cn.trio.aop.logger.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StringUtils;

import io.github.zh.cn.trio.aop.croe.aspect.AbstractAopAspect;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;
import io.github.zh.cn.trio.aop.croe.utils.BeanUtils;
import io.github.zh.cn.trio.aop.logger.annotation.TrioLogger;
import io.github.zh.cn.trio.aop.logger.context.LoggerBeanContext;
import io.github.zh.cn.trio.aop.logger.face.AbstarctLoggerFace;
import io.github.zh.cn.trio.aop.plug.format.Format;

@Aspect
public class TrioLoggerAnnotationAspect extends AbstractAopAspect {

	private Format defaultFormat;

	private AopStrategy defaultAopStrategy;
	
	private AbstarctLoggerFace defaultAbstarctLoggerFace;


	public Format getDefaultFormat() {
		return defaultFormat;
	}

	public void setDefaultFormat(Format defaultFormat) {
		this.defaultFormat = defaultFormat;
	}

	public AopStrategy getDefaultAopStrategy() {
		return defaultAopStrategy;
	}

	public void setDefaultAopStrategy(AopStrategy defaultAopStrategy) {
		this.defaultAopStrategy = defaultAopStrategy;
	}

	@Around("@annotation(io.github.zh.cn.trio.aop.logger.annotation.TrioLogger)")
	public Object proxyAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		return super.proxy(proceedingJoinPoint);
	}

	@SuppressWarnings("unchecked")
	@Override
	public LoggerBeanContext initContext(AopUtilContext aopUtilContext) {
		LoggerBeanContext loggerBeanContext = new LoggerBeanContext();
		loggerBeanContext = LoggerBeanContext.copyContext(aopUtilContext, loggerBeanContext);

		TrioLogger trioLogger = loggerBeanContext.getTargetMethod().getAnnotation(TrioLogger.class);
		AbstarctLoggerFace loggerFace = BeanUtils.getBean(getApplicationContext(), trioLogger.loggerFace(), AbstarctLoggerFace.class, defaultAbstarctLoggerFace);
		
		loggerBeanContext.initMap(loggerBeanContext.getTimeToLevelMap(), trioLogger.targetTime(),
				trioLogger.targetLevel());

		String targetName = trioLogger.targetName();
		if (StringUtils.isEmpty(targetName)) {
			targetName = loggerBeanContext.getTarget().getClass().getName();
		}
		loggerBeanContext.initMap(loggerBeanContext.getLevelToNameMap(), trioLogger.targetLevel(), targetName);
		loggerBeanContext.initMap(loggerBeanContext.getNameToModelMap(), targetName, trioLogger.modelString());
	
		loggerBeanContext.setLoggerFace(loggerFace);
		
		return loggerBeanContext;
	}

}
