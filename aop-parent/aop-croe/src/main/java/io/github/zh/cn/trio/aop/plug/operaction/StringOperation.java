package io.github.zh.cn.trio.aop.plug.operaction;

/**
 * redis 操作
 * 
 *
 */
public interface StringOperation {

	/**
	 * 
	 * 
	 * @param key key
	 * @return  是否存在建
	 */
	boolean exists(String key);

	/**
	 * @param key key
	 * @param val  val
	 * @param cacheTime cacheTime
	 * @return 设置值并且设置超时时间
	 */
	boolean expireat(String key, String val, int cacheTime);

	/**
	 * @param key key
	 * @return 取值
	 */
	String get(String key);

	/**
	 * 
	 * 
	 * @param key key
	 * @return 删除
	 */
	boolean del(String key);

}
