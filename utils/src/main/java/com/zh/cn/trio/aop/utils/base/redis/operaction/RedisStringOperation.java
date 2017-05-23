package com.zh.cn.trio.aop.utils.base.redis.operaction;

/**
 * redis 操作
 * 
 * @author Administrator
 *
 */
public interface RedisStringOperation {

	/**
	 * 是否存在建
	 * 
	 * @param key
	 * @return
	 */
	boolean exists(String key);

	/**
	 * 设置值并且设置超时时间
	 * 
	 * @param key
	 * @param val
	 * @param cacheTime
	 * @return
	 */
	boolean expireat(String key, String val, int cacheTime);

	/**
	 * 取值
	 * 
	 * @param key
	 * @return
	 */
	String get(String key);

	/**
	 * 删除
	 * 
	 * @param key
	 * @return
	 */
	boolean del(String key);

}
