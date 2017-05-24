package com.zh.cn.trio.aop.utils.base.serialization;

public interface Serialization {

	String serialization(Object object);

	Object forSerialization(String val, Class<?> returnClass);

}
