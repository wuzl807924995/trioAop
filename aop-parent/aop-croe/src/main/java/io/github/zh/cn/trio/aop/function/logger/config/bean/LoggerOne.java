package io.github.zh.cn.trio.aop.function.logger.config.bean;

public class LoggerOne {

	private String level;
	private String name;
	private String info;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public LoggerOne() {
		super();
	}

	public LoggerOne(String level, String name, String info) {
		this.level = level;
		this.name = name;
		this.info = info;
	}

}
