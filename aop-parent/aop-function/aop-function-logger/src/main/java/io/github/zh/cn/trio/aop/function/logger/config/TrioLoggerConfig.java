package io.github.zh.cn.trio.aop.function.logger.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TrioLoggerConfig {

	private Map<String, String> timeToLevelMap;
	private Map<String, String> levelToNameMap;
	private Map<String, String> nameToModelMap;

	public Map<String, String> getTimeToLevelMap() {
		if (timeToLevelMap == null) {
			timeToLevelMap = new HashMap<>();
		}
		return timeToLevelMap;
	}

	public void setTimeToLevelMap(Map<String, String> timeToLevelMap) {
		this.timeToLevelMap = timeToLevelMap;
	}

	public Map<String, String> getLevelToNameMap() {
		if (levelToNameMap == null) {
			levelToNameMap = new HashMap<>();
		}
		return levelToNameMap;
	}

	public void setLevelToNameMap(Map<String, String> levelToNameMap) {
		this.levelToNameMap = levelToNameMap;
	}

	public Map<String, String> getNameToModelMap() {
		if (nameToModelMap == null) {
			nameToModelMap = new HashMap<>();
		}
		return nameToModelMap;
	}

	public void setNameToModelMap(Map<String, String> nameToModelMap) {
		this.nameToModelMap = nameToModelMap;
	}

	public TrioLoggerConfig() {

	}

	public TrioLoggerConfig(String time, String level, String name, String model) {
		getTimeToLevelMap().put(time, level);
		getLevelToNameMap().put(level, name);
		getNameToModelMap().put(name, model);
	}

	public TrioLoggerConfig(String time,String level) {
		getTimeToLevelMap().put(time, level);
	}
	
	public TrioLoggerConfig(String[] time,String level[]) {
		for (int i = 0; i < time.length; i++) {
			getTimeToLevelMap().put(time[i], level[i]);
		}
	}
	
	public String[] getTargetTime() {
		Set<String> set = getTimeToLevelMap().keySet();
		String[] array=new String[set.size()];
		return set.toArray(array);
	}
}
