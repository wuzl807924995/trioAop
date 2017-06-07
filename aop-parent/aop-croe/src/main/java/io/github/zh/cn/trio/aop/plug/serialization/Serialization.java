package io.github.zh.cn.trio.aop.plug.serialization;

public interface Serialization {

	/**
	 * 
	 * @param object 对象
	 * @return 序列化对象
	 */
	String serialization(Object object);

	/**
	 * 
	 * @param val 被序列化的值
	 * @param returnClass 反序列化类型
	 * @return 反序列化对象
	 */
	<T> T forSerialization(String val, Class<?> returnClass);

}
