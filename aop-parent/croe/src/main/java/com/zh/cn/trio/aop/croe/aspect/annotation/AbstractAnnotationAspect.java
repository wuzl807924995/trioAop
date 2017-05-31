package com.zh.cn.trio.aop.croe.aspect.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.zh.cn.trio.aop.croe.aspect.AbstractAopBeanAspect;
import com.zh.cn.trio.aop.croe.context.AopUtilConfig;

/**
 * 注解aop
 *
 * @param <T>
 *            配置
 * @param <E>
 *            注解
 */
public abstract class AbstractAnnotationAspect<T extends AopUtilConfig<T>, E extends Annotation>
		extends AbstractAopBeanAspect<T> {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public Object proxyAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		try {
			// 读注解
			E eAnnotation = this.getAnnotation(proceedingJoinPoint, getAnnotationClass());
			// 注解转配置
			T config = this.crateConfig(eAnnotation);
			// 加载配置
			this.setConfigBean(config);
		} catch (Exception e) {
			logger.error("AnnotationAspect init config error", e);
		}
		return super.proxy(proceedingJoinPoint);
	}

	public E getAnnotation(ProceedingJoinPoint proceedingJoinPoint, Class<E> annotationClass) {
		MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
		Method method = signature.getMethod();
		E annotation = method.getAnnotation(annotationClass);
		return annotation;
	}

	public <U> U getBean(String beanName, Class<U> tcls, U defaultBean) {
		if (StringUtils.isEmpty(beanName)) {
			return defaultBean;
		} else {
			try {
				return getApplicationContext().getBean(beanName, tcls);
			} catch (Exception e) {
				logger.error("getBean has exception beanName:" + beanName + " class:" + tcls, e);
				return defaultBean;
			}
		}
	}

	public abstract Class<E> getAnnotationClass();

	public abstract T crateConfig(E eAnnotation);
}
