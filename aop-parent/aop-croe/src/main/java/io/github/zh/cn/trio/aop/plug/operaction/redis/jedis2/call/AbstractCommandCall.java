package io.github.zh.cn.trio.aop.plug.operaction.redis.jedis2.call;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.JedisPool;

public abstract class AbstractCommandCall implements CommandCall {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@SuppressWarnings("deprecation")
	@Override
	public <T> T call(JedisPool jedisPool) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return exec(jedis);
		} catch (Exception e) {
			logger.error("jedisPool getResouce or exec has exception");
			throw e;
		} finally {
			if (jedis != null) {
				jedisPool.returnResource(jedis);
			}
		}
	}

	public abstract <T> T exec(JedisCommands commands);
}
