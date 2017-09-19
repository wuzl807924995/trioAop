package io.github.zh.cn.trio.aop.plug.operaction.guava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import io.github.zh.cn.trio.aop.plug.operaction.StringOperation;

//TODO 
public class GuavaStringOperation implements StringOperation{

	
	private Cache<Object, Object> cache;
	
	
	public void init() {
		cache=CacheBuilder.newBuilder().build();
	}
	
	@Override
	public boolean exists(String key) {
		try {
			cache.get(key, new Callable<Object>() {

				@Override
				public Object call() throws Exception {
					return null;
				}
			});
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean expireat(String key, String val, int cacheTime) {
		
		return false;
	}

	@Override
	public String get(String key) {
		
		return null;
	}

	@Override
	public boolean del(String key) {
		
		return false;
	}

}
