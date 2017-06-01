package io.github.zh.cn.trio.aop.croe.base.redis.operaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@SuppressWarnings("deprecation")
public class RedisStringOperationImpl implements RedisStringOperation {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private JedisPool jedisPool;

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	@Override
	public boolean exists(String key) {
		Jedis jedis = jedisPool.getResource();
		try {
			return jedis.exists(key);
		} catch (Exception e) {
			logger.error("exists ", e);
			return false;
		} finally {
			jedisPool.returnResource(jedis);
		}
	}

	@Override
	public boolean expireat(String key, String val, int cacheTime) {
		Jedis jedis = jedisPool.getResource();
		try {
			jedis.set(key, val);
			if (cacheTime > 0) {
				jedis.expire(key, cacheTime);
			}
			return true;
		} catch (Exception e) {
			logger.error("expireat ", e);
			return false;
		} finally {
			jedisPool.returnResource(jedis);
		}
	}

	@Override
	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		try {
			return jedis.get(key);
		} catch (Exception e) {
			logger.error("get ", e);
			return null;
		} finally {
			jedisPool.returnResource(jedis);
		}
	}

	@Override
	public boolean del(String key) {
		Jedis jedis = jedisPool.getResource();
		try {
			jedis.del(key);
			return true;
		} catch (Exception e) {
			logger.error("del ", e);
			return false;
		} finally {
			jedisPool.returnResource(jedis);
		}
	}

}
