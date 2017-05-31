package com.zh.cn.trio.aop.croe.base.format;

public interface Format {

	<T> T format(Object formatBean, String expressionString);

}
