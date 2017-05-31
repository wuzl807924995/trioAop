package com.zh.cn.trio.aop.croe.base.serialization;

public interface Serialization {

	String serialization(Object object);

	Object forSerialization(String val, Class<?> returnClass);

}
