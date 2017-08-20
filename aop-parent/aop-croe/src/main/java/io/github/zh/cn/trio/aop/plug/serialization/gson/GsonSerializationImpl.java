package io.github.zh.cn.trio.aop.plug.serialization.gson;

import com.google.gson.Gson;

import io.github.zh.cn.trio.aop.plug.serialization.Serialization;

public class GsonSerializationImpl implements Serialization {

	private Gson gson;

	public Gson getGson() {
		return gson;
	}

	public void setGson(Gson gson) {
		this.gson = gson;
	}

	public Gson getDefaultGson() {
		if (gson == null) {
			gson = new Gson();
		}
		return gson;
	}

	@Override
	public String serialization(Object object) {
		return getDefaultGson().toJson(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T forSerialization(String val, Class<?> returnClass) {
		return (T) getDefaultGson().fromJson(val, returnClass);
	}

}
