package io.github.zh.cn.trio.aop.function.validation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import io.github.zh.cn.trio.aop.croe.aspect.AbstractAopAspect;
import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.validation.adapter.ValidationAdapter;

@Aspect
public class TrioBeanAnnotationAspect extends AbstractAopAspect {

	private static final String[] targetTime = new String[] { RunTimeConfig.TIME_BEFORE };

	private ValidationAdapter validationAdapter;

	public ValidationAdapter getValidationAdapter() {
		return validationAdapter;
	}

	public void setValidationAdapter(ValidationAdapter validationAdapter) {
		this.validationAdapter = validationAdapter;
	}

	@Around("@annotation(io.github.zh.cn.trio.aop.function.validation.annotation.TrioBeanValidation)")
	public Object proxyAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		return super.proxy(proceedingJoinPoint);
	}

	@Override
	public RunTimeConfig initConfig(RunTimeContext runTimeContext) {
		RunTimeConfig runTimeConfig = new RunTimeConfig();
		runTimeConfig.setRunTimeAdapter(validationAdapter);
		runTimeConfig.setTargetTimes(targetTime);
		
		return runTimeConfig;
	}

}
