package com.zh.cn.trio.aop.hystrix.model;

import java.lang.reflect.Method;

import com.zh.cn.trio.aop.hystrix.validation.HystrixResult;

public interface HystrixModel {

	HystrixResult hystrixValidation(Object target, Method targetMethod, Object[] targetArgs);
}
