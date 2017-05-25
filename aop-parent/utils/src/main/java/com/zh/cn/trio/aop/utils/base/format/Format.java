package com.zh.cn.trio.aop.utils.base.format;

public interface Format {

	<T> T format(Object formatBean, String expressionString);

}
