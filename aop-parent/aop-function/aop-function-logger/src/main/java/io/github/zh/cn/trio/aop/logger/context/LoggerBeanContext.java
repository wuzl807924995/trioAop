package io.github.zh.cn.trio.aop.logger.context;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import io.github.zh.cn.trio.aop.config.abs.context.AbsContext;
import io.github.zh.cn.trio.aop.logger.face.AbstarctLoggerFace;

/**
 * 
 * 日志配置
 */
public class LoggerBeanContext extends AbsContext {

	public static final String LEVEL_INFO = "INFO";
	public static final String LEVEL_ERROR = "ERROR";
	public static final String LEVEL_DEBUG = "DEBUG";
	public static final String LEVEL_WARN = "WARN";

	private Map<String, String> timeToLevelMap;
	private Map<String, String> levelToNameMap;
	private Map<String, String> nameToModelMap;

	private AbstarctLoggerFace loggerFace;

	public AbstarctLoggerFace getLoggerFace() {
		return loggerFace;
	}

	public void setLoggerFace(AbstarctLoggerFace loggerFace) {
		this.loggerFace = loggerFace;
	}

	public Map<String, String> getTimeToLevelMap() {
		return timeToLevelMap;
	}

	public void setTimeToLevelMap(Map<String, String> timeToLevelMap) {
		this.timeToLevelMap = timeToLevelMap;
	}

	public Map<String, String> getLevelToNameMap() {
		return levelToNameMap;
	}

	public void setLevelToNameMap(Map<String, String> levelToNameMap) {
		this.levelToNameMap = levelToNameMap;
	}

	public Map<String, String> getNameToModelMap() {
		return nameToModelMap;
	}

	public void setNameToModelMap(Map<String, String> nameToModelMap) {
		this.nameToModelMap = nameToModelMap;
	}

	public String getLevel(String time) {
		return getTimeToLevelMap().get(time);
	}

	public String getName(String level) {
		return getLevelToNameMap().get(level);
	}

	public String getModel(String name) {
		return getNameToModelMap().get(name);
	}

	public <K, V> Map<K, V> initMap(Map<K, V> map, K k, V v) {
		if (CollectionUtils.isEmpty(map)) {
			map = new HashMap<>();
		}
		map.put(k, v);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public AbstarctLoggerFace getBeanModel() {
		return loggerFace;
	}
}
