package io.github.zh.cn.trio.aop.croe.context;

import java.lang.reflect.Method;

import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;

/**
 * 上下文
 */
public class AopUtilContext {

	/**
	 * 触发时间--前置触发
	 */
	public static final String TIME_BEFORE = "BEFORE";
	/**
	 * 触发时间--后置触发
	 */
	public static final String TIME_AFTER = "AFTER";
	/**
	 * 触发时间--异常触发
	 */
	public static final String TIME_ERROR = "ERROR";

	public static final String TIME_AROUND_STARAT = "AROUND_SATART";

	public static final String TIME_AROUND_END = "AROUND_END";

	/**
	 * 环绕开启时间
	 */
	private long aroundTimeStarat;

	/**
	 * 环绕结束时间
	 */
	private long aroundTimeEnd;

	/**
	 * 触发时间
	 */
	private String[] targetTimes;

	/**
	 * 策略
	 */
	private AopStrategy aopStrategy;

	private ApplicationContext applicationContext;

	/**
	 * 是否设置过目标结果
	 */
	private boolean setResult;

	/**
	 * 目标方法参数类类型
	 */
	private Class<?>[] targetArgsClass;

	/**
	 * 目标方法返回值类型
	 */
	private Class<?> returnClass;

	/**
	 * aop切面
	 */
	private MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint;

	/**
	 * 目标实体
	 */
	private Object target;
	/**
	 * 拦截方法
	 */
	private Method targetMethod;
	/**
	 * 拦截方法入参
	 */
	private Object[] targetArgs;
	/**
	 * 返回值
	 */
	private Object resultObject;

	/**
	 * 目标方法抛出的异常
	 */
	private Throwable throwable;

	public boolean checkEnable(String time) {
		if (targetTimes == null || StringUtils.isEmpty(time)) {
			return false;
		}
		for (String string : targetTimes) {
			if (time.equals(string)) {
				return true;
			}
		}
		return false;
	}

	public String[] getTargetTimes() {
		return targetTimes;
	}

	public void setTargetTimes(String[] targetTimes) {
		this.targetTimes = targetTimes;
	}

	public AopStrategy getAopStrategy() {
		return aopStrategy;
	}

	public void setAopStrategy(AopStrategy aopStrategy) {
		this.aopStrategy = aopStrategy;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public Object getTarget() {
		if (target == null) {
			target = methodInvocationProceedingJoinPoint.getTarget();
		}
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public long getAroundTimeStarat() {
		return aroundTimeStarat;
	}

	public void setAroundTimeStarat(long aroundTimeStarat) {
		this.aroundTimeStarat = aroundTimeStarat;
	}

	public long getAroundTimeEnd() {
		return aroundTimeEnd;
	}

	public void setAroundTimeEnd(long aroundTimeEnd) {
		this.aroundTimeEnd = aroundTimeEnd;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	public MethodInvocationProceedingJoinPoint getMethodInvocationProceedingJoinPoint() {
		return methodInvocationProceedingJoinPoint;
	}

	public void setMethodInvocationProceedingJoinPoint(
			MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint) {
		this.methodInvocationProceedingJoinPoint = methodInvocationProceedingJoinPoint;
	}

	public Object getResultObject() {
		return resultObject;
	}

	public void setResultObject(Object resultObject) {
		this.setResult = true;
		this.resultObject = resultObject;
	}

	public Object[] getTargetArgs() {
		if (targetArgs == null) {
			targetArgs = methodInvocationProceedingJoinPoint.getArgs();
		}
		return targetArgs;
	}

	public void setTargetArgs(Object[] targetArgs) {
		this.targetArgs = targetArgs;
	}

	public Method getTargetMethod() {
		if (targetMethod == null) {
			MethodSignature signature = (MethodSignature) methodInvocationProceedingJoinPoint.getSignature();
			targetMethod = signature.getMethod();
		}
		return targetMethod;
	}

	public void setTargetMethod(Method targetMethod) {
		this.targetMethod = targetMethod;
	}

	public Class<?>[] getTargetArgsClass() {
		if (targetArgsClass == null) {
			targetArgsClass = getTargetMethod().getParameterTypes();
		}
		return targetArgsClass;
	}

	public void setTargetArgsClass(Class<?>[] targetArgsClass) {
		this.targetArgsClass = targetArgsClass;
	}

	public Class<?> getReturnClass() {
		if (returnClass == null) {
			returnClass = getTargetMethod().getReturnType();
		}
		return returnClass;
	}

	public void setReturnClass(Class<?> returnClass) {
		this.returnClass = returnClass;
	}

	public boolean isSetResult() {
		return setResult;
	}

	public static <T extends AopUtilContext> T copyContext(AopUtilContext aopUtilContext,T t) {
		t.setApplicationContext(aopUtilContext.getApplicationContext());
		t.setMethodInvocationProceedingJoinPoint(aopUtilContext.getMethodInvocationProceedingJoinPoint());
		return t;
	}
	
}
