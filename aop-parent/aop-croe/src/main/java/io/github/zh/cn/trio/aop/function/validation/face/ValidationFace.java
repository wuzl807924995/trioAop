package io.github.zh.cn.trio.aop.function.validation.face;

import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.validation.config.ValidationConfig;
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
	 * @param <T> 任意类型
	 * @return 验证结果
	 */
	<T> IReturnResult<T> validation(RunTimeContext context, ValidationConfig validationConfig);

	/**
	 * 处理验证结果
	 * @param context 环境
	 * @param runTimeConfig 配置
	 */
	void doValidation(RunTimeContext context, ValidationConfig validationConfig);
}
