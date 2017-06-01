package io.github.zh.cn.trio.aop.croe.base.serialization;

import com.google.gson.Gson;

public class GsonSerializationImpl implements Serialization {

	@Override
	public String serialization(Object object) {
		Gson gson = new Gson();
		return gson.toJson(object);
	}

	@Override
	public Object forSerialization(String val, Class<?> returnClass) {
		Gson gson = new Gson();
		return gson.fromJson(val, returnClass);
	}

}
