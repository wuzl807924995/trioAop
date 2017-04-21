package com.zh.cn.trio.aop.utils.base.format;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.zh.cn.trio.aop.utils.aspect.AopUtilConfig;
import com.zh.cn.trio.aop.utils.aspect.AopUtilContext;

public class SpelFromat implements Format {

	@Override
	public Object formatContext(AopUtilContext<? extends AopUtilConfig> aopContext) {
		Object[] args = aopContext.getTargetArgs();
		if (args == null) {
			// 沒有参数 直接返回
			return aopContext.getAopUtilConfig().getFormatString();
		}
		String formatString = aopContext.getAopUtilConfig().getFormatString();

		ExpressionParser parser = new SpelExpressionParser();
		// 解析表达式
		Expression expression = parser.parseExpression(formatString);
		// 构造上下文
		EvaluationContext context = new StandardEvaluationContext();

		// 方法结果
		context.setVariable("rs", aopContext.getResultObject());
		// 方法参数
		for (int i = 0; i < args.length; i++) {
			context.setVariable("args" + i, args[i]);
		}
		// 解析
		Object object = expression.getValue(context);
		return object;
	}

}
