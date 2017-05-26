package com.zh.cn.trio.aop.hystrix.model;

import java.lang.reflect.Method;

import com.zh.cn.trio.aop.hystrix.validation.HystrixResult;

public class SimpleHystrixModel implements HystrixModel {

	public HystrixResult hystrixValidation(Object target, Method targetMethod, Object[] targetArgs) {
		HystrixResult hystrixResult=new HystrixResult();
		hystrixResult.setSuccess(false);
		return hystrixResult;
	}

}
