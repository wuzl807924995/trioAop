package io.github.zh.cn.trio.aop.plug.operaction.redis.jedis2;

import redis.clients.jedis.JedisPool;

public abstract class PoolThreadLocal {
	
	private PoolThreadLocal(){
		super();
	}

	private static final ThreadLocal<JedisPool> threadLocal = new ThreadLocal<>();

	public static void setPool(JedisPool jedisPool) {
		threadLocal.set(jedisPool);
	}

	public static JedisPool getPool() {
		return threadLocal.get();
	}

	public static void remove() {
		threadLocal.remove();
	}

}
