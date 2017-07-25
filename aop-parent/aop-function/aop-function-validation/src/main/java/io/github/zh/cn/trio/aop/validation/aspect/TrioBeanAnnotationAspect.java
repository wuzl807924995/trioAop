package io.github.zh.cn.trio.aop.validation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import io.github.zh.cn.trio.aop.croe.aspect.AbstractAopAspect;
import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;
import io.github.zh.cn.trio.aop.croe.utils.BeanUtils;
import io.github.zh.cn.trio.aop.validation.annotation.TrioBeanValidation;
import io.github.zh.cn.trio.aop.validation.context.ValidationBeanContext;
import io.github.zh.cn.trio.aop.validation.face.ValidationFace;

@Aspect
public class TrioBeanAnnotationAspect extends AbstractAopAspect<ValidationBeanContext> {

	private static final String[] targetTime = new String[] { ValidationBeanContext.TIME_BEFORE };

	@Autowired
	@Qualifier("validationStrategy")
	private AopStrategy defaultAopStrategy;

	public AopStrategy getDefaultAopStrategy() {
		return defaultAopStrategy;
	}

	public void setDefaultAopStrategy(AopStrategy defaultAopStrategy) {
		this.defaultAopStrategy = defaultAopStrategy;
	}

	@Around("@annotation(io.github.zh.cn.trio.aop.validation.annotation.TrioBeanValidation)")
	public Object proxyAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		return super.proxy(proceedingJoinPoint);
	}

	@Override
	public ValidationBeanContext initContext(MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint) {
		ValidationBeanContext validationBeanContext = new ValidationBeanContext();
		validationBeanContext.setMethodInvocationProceedingJoinPoint(methodInvocationProceedingJoinPoint);
		validationBeanContext.setApplicationContext(getApplicationContext());

		TrioBeanValidation trioBeanValidation = validationBeanContext.getTargetMethod()
				.getAnnotation(TrioBeanValidation.class);

		AopStrategy aopStrategy = BeanUtils.getBean(getApplicationContext(), trioBeanValidation.aopStrategy(),
				AopStrategy.class, defaultAopStrategy);

		ValidationFace validationFace = BeanUtils.getBean(getApplicationContext(), trioBeanValidation.beanName(),
				ValidationFace.class, null);

		validationBeanContext.setAopStrategy(aopStrategy);
		validationBeanContext.setValidationFace(validationFace);
		validationBeanContext.setTargetTimes(targetTime);

		return validationBeanContext;
	}

}
