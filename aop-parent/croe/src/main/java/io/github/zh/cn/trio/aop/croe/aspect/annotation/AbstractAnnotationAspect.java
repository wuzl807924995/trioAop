package io.github.zh.cn.trio.aop.croe.aspect.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import io.github.zh.cn.trio.aop.croe.aspect.AbstractAopBeanAspect;
import io.github.zh.cn.trio.aop.croe.context.AopUtilConfig;

/**
 * 注解aop
 *
 * @param <T>
 *            配置
 * @param <E>
 *            注解
 */
public abstract class AbstractAnnotationAspect<T extends AopUtilConfig, E extends Annotation>
		extends AbstractAopBeanAspect<T> {

	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 拦截aop的模板方法
	 * @param proceedingJoinPoint 拦截点 @see MethodInvocationProceedingJoinPoint
	 * @return 目标方法返回值
	 * @throws Throwable 目标方法异常
	 */
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

	/**
	 * 读取目标注解
	 * @param proceedingJoinPoint 切面
	 * @param annotationClass 注解
	 * @return 目标注解
	 */
	public E getAnnotation(ProceedingJoinPoint proceedingJoinPoint, Class<E> annotationClass) {
		MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
		Method method = signature.getMethod();
		E annotation = method.getAnnotation(annotationClass);
		return annotation;
	}

	/**
	 * 读默认配置
	 * @param beanName beanName
	 * @param tcls 配置类型
	 * @param defaultBean 读取失败时返回的默认配置
	 * @return
	 */
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

	/**
	 * 
	 * @return 目标注解的类型
	 */
	public abstract Class<E> getAnnotationClass();

	/**
	 * @param eAnnotation 目标注解
	 * @return 通过注解转化为配置
	 */
	public abstract T crateConfig(E eAnnotation);
}
