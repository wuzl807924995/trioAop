package io.github.zh.cn.trio.aop.function.enhance.config;

import java.util.ArrayList;
import java.util.List;

import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.function.enhance.config.bean.EnhanceOne;

public class EnhanceConfig extends RunTimeConfig {
	private List<EnhanceOne> enhanceList;

	public List<EnhanceOne> getEnhanceList() {
		return enhanceList;
	}

	public void setEnhanceList(List<EnhanceOne> enhanceList) {
		this.enhanceList = enhanceList;
	}

	public void addOne(EnhanceOne enhanceOne) {
		if (enhanceList == null) {
			enhanceList = new ArrayList<>();
		}
		enhanceList.add(enhanceOne);
	}
}
