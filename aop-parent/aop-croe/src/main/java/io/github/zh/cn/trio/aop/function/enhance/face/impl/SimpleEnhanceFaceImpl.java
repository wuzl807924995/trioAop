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
			//执行增强结果
			temp= enhanceOne.getEnhanceType().enhanceDecorate(enhanceOne);
			if (enhanceOne.isMethodResult()) {
				//是结果 写入到结果集
				runTimeContext.setResultObject(temp);
			}else {
				//是参数 写入到参参数集
				Object[] args = runTimeContext.getTargetArgs();
				args[enhanceOne.getTargetIndex()]=temp;
				runTimeContext.setTargetArgs(args);
			}
		}
	}

}
