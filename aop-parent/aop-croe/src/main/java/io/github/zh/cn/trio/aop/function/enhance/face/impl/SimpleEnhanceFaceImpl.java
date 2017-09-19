package io.github.zh.cn.trio.aop.function.enhance.face.impl;

import java.util.List;

import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.enhance.config.EnhanceConfig;
import io.github.zh.cn.trio.aop.function.enhance.config.bean.EnhanceOne;
import io.github.zh.cn.trio.aop.function.enhance.face.EnhanceFace;


public class SimpleEnhanceFaceImpl implements EnhanceFace{

	
	
	@Override
	public void enhaceTarget(RunTimeContext runTimeContext, EnhanceConfig enhanceConfig) {
		
		List<EnhanceOne> list = enhanceConfig.getEnhanceList();
		EnhanceOne enhanceOne;
		Object temp;
		for (int i = 0; i < list.size(); i++) {
			enhanceOne=list.get(i);
			temp= enhanceOne.getEnhanceType().enhanceDecorate(enhanceOne);
			enhanceOne.setEnhanceRs(temp);
		}
	}

}
