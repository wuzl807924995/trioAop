package io.github.zh.cn.trio.aop.plug.operaction.redis.jedis2;

import io.github.zh.cn.trio.aop.plug.operaction.StringOperation;
import io.github.zh.cn.trio.aop.plug.operaction.redis.jedis2.call.AbstractCommandCall;
import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.JedisPool;

@SuppressWarnings("unchecked")
public class CallRedisStringOperactionImpl implements StringOperation {

	@Override
	public boolean exists(final String key) {
		JedisPool jedisPool = PoolThreadLocal.getPool();
		return new AbstractCommandCall() {
			@Override
			public <T> T exec(JedisCommands commands) {
				return (T) commands.exists(key);
			}
		}.call(jedisPool);
	}

	@Override
	public boolean expireat(final String key, final String val, final int cacheTime) {
		JedisPool jedisPool = PoolThreadLocal.getPool();
		return new AbstractCommandCall() {
			@Override
			public <T> T exec(JedisCommands commands) {
				commands.set(key, val);
				if (cacheTime > 0) {
					commands.expire(key, cacheTime);
				}
				return (T) Boolean.TRUE;
			}
		}.call(jedisPool);
	}

	@Override
	public String get(final String key) {
		JedisPool jedisPool = PoolThreadLocal.getPool();
		return new AbstractCommandCall() {
			@Override
			public <T> T exec(JedisCommands commands) {
				return (T) commands.get(key);
			}
		}.call(jedisPool);
	}

	@Override
	public boolean del(final String key) {
		JedisPool jedisPool = PoolThreadLocal.getPool();
		return new AbstractCommandCall() {
			@Override
			public <T> T exec(JedisCommands commands) {
				commands.del(key);
				return (T) Boolean.TRUE;
			}
		}.call(jedisPool);
	}

}
