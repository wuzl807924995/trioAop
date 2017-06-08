package io.github.zh.cn.trio.aop.validation.bean.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import io.github.zh.cn.trio.aop.croe.aspect.AbstractAopAspect;
import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;
import io.github.zh.cn.trio.aop.croe.utils.BeanUtils;
import io.github.zh.cn.trio.aop.plug.format.Format;
import io.github.zh.cn.trio.aop.validation.bean.annotation.TrioBeanValidation;
import io.github.zh.cn.trio.aop.validation.context.ValidationBeanContext;
import io.github.zh.cn.trio.aop.validation.face.AbstractValidationFace;

public class TrioBeanAnnotationAspect extends AbstractAopAspect<ValidationBeanContext> {

	@Autowired
	private Format defaultFormat;

	@Autowired
	private AopStrategy defaultAopStrategy;

	private AbstractValidationFace defaultValidationFace;

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

	public AbstractValidationFace getDefaultValidationFace() {
		return defaultValidationFace;
	}

	public void setDefaultValidationFace(AbstractValidationFace defaultValidationFace) {
		this.defaultValidationFace = defaultValidationFace;
	}

	@Around("@annotation(io.github.zh.cn.trio.aop.validation.bean.annotation.TrioBeanValidation)")
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
		Format format = BeanUtils.getBean(getApplicationContext(), trioBeanValidation.format(), Format.class,
				defaultFormat);
		AbstractValidationFace validationFace = BeanUtils.getBean(getApplicationContext(),
				trioBeanValidation.beanName(), AbstractValidationFace.class, defaultValidationFace);

		validationBeanContext.setAopStrategy(aopStrategy);
		validationBeanContext.setFormat(format);
		validationBeanContext.setValidationFace(validationFace);

		return validationBeanContext;
	}

}
