package com.zh.cn.trio.aop.utils.base.format;

import java.util.Map;

import org.springframework.context.ApplicationContext;


public interface Format {

	<T> T format(Object formatBean, String expressionString);

	<T> T format(Object formatBean, String expressionString,Map<String, Object> map);

	<T> T format(Object formatBean,ApplicationContext applicationContext, String expressionString);
	
	<T> T format(Object formatBean,ApplicationContext applicationContext, String expressionString,Map<String, Object> map);
}
