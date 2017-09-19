package io.github.zh.cn.trio.aop.function.validation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import io.github.zh.cn.trio.aop.croe.aspect.AbstractApplictionAopAspect;
import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.validation.adapter.ValidationAdapter;
import io.github.zh.cn.trio.aop.function.validation.annotation.TrioBeanValidation;
import io.github.zh.cn.trio.aop.function.validation.config.ValidationConfig;
import io.github.zh.cn.trio.aop.function.validation.face.ValidationFace;

@Aspect
public class TrioBeanAnnotationAspect extends AbstractApplictionAopAspect {

	private static final String[] TARGET_TIME = new String[] { RunTimeConfig.TIME_BEFORE };

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
	public ValidationConfig initConfig(RunTimeContext runTimeContext) {
		TrioBeanValidation trioBeanValidation = runTimeContext.getAnnotation(TrioBeanValidation.class);
		ValidationConfig runTimeConfig = new ValidationConfig();
		runTimeConfig.setValidationFace(getApplicationContext().getBean(trioBeanValidation.beanName(),ValidationFace.class));
		runTimeConfig.setRunTimeAdapter(validationAdapter);
		runTimeConfig.setTargetTimes(TARGET_TIME);
		return runTimeConfig;
	}

}
