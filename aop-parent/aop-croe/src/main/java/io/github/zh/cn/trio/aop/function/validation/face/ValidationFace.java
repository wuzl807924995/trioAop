package io.github.zh.cn.trio.aop.function.validation.face;

import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.validation.result.IReturnResult;

/**
 * 
 *验证器接口
 */
public interface ValidationFace {

	/**
	 * 执行验证得到验证结果
	 * @param context 环境
	 * @param runTimeConfig 配置
	 * @return 验证结果
	 */
	<T> IReturnResult<T> validation(RunTimeContext context, RunTimeConfig runTimeConfig);

	/**
	 * 处理验证结果
	 * @param context 环境
	 * @param runTimeConfig 配置
	 */
	void doValidation(RunTimeContext context, RunTimeConfig runTimeConfig);
}
