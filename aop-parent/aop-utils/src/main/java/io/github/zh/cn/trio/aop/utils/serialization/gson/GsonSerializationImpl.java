package io.github.zh.cn.trio.aop.utils.serialization.gson;

import com.google.gson.Gson;

import io.github.zh.cn.trio.aop.utils.serialization.Serialization;

public class GsonSerializationImpl implements Serialization {

	@Override
	public String serialization(Object object) {
		Gson gson = new Gson();
		return gson.toJson(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T  forSerialization(String val, Class<?> returnClass) {
		Gson gson = new Gson();
		return (T) gson.fromJson(val, returnClass);
	}

}
