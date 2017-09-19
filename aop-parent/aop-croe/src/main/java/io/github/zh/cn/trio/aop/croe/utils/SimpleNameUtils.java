package io.github.zh.cn.trio.aop.croe.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;

import io.github.zh.cn.trio.aop.croe.utils.face.SimpleName;

public class SimpleNameUtils implements ApplicationContextAware{

	private ApplicationContext applicationContext;
	
	private final Map<Class<?>, Map<String, ? extends SimpleName >> cache;
	
	public SimpleNameUtils() {
		cache=new HashMap<>();
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends SimpleName> Map<String, T> getSimpleBeanMap(Class<T> cls){
		if (cache.containsKey(cls)) {
			return (Map<String, T>) cache.get(cls);
		}
		Map<String, T> springBean = applicationContext.getBeansOfType(cls);
		Map<String, T> map=new HashMap<>();
		T temp;
		for (String key : springBean.keySet()) {
			temp=springBean.get(key);
			map.put(temp.getSimpleName(), temp);
		}
		cache.put(cls, map);
		return map;
	}

	public <T extends SimpleName> T getSipleBean(Class<T> cls,String key) {
		Map<String, T> map = getSimpleBeanMap(cls);
		return map.get(key);
	}
	
	public <T extends SimpleName> T getSipleBeanWithException(Class<T> cls,String key) {
		T t = getSipleBean(cls, key);
		if (StringUtils.isEmpty(t)) {
			throw new RuntimeException(key+" is not a "+cls.getName());
		}
		return t;
	}
}
