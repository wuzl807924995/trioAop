package com.zh.cn.trio.aop.utils.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import com.zh.cn.trio.aop.utils.context.AopUtilConfig;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;

/**
 * 泛型模板配置
 *
 * @param <T>
 */
public class AbstractAopBeanAspect<T extends AopUtilConfig<T>> extends AbstractAopAspect<T> {

	private T configBean;

	public T getConfigBean() {
		return configBean;
	}

	public void setConfigBean(T configBean) {
		this.configBean = configBean;
	}

	@Override
	public T createBean(AopUtilContext<T> aopUtilContext) {
		return configBean;
	}

	
	public <E extends Annotation> E getAnnotation(ProceedingJoinPoint proceedingJoinPoint, Class<E> annotationClass){
		MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
		Method method = signature.getMethod();
		E annotation = method.getAnnotation(annotationClass);
		return annotation;
	}
}
