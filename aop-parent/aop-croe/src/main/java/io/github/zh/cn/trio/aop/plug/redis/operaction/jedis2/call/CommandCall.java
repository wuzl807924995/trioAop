package io.github.zh.cn.trio.aop.plug.redis.operaction.jedis2.call;

import redis.clients.jedis.JedisPool;

public interface CommandCall {

	public <T> T call(JedisPool jedisPool);
}
