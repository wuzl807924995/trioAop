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
	public Object formatContext(AopUtilContext<? extends AopUtilConfig<?>> aopContext) {
		String formatString = aopContext.getAopUtilConfig().getFormatString();

		ExpressionParser parser = new SpelExpressionParser();
		// 解析表达式
		Expression expression = parser.parseExpression(formatString);
		// 构造上下文
		EvaluationContext context = new StandardEvaluationContext();

		// 方法结果
		context.setVariable("aopContext", aopContext);
		// 解析
		Object object = expression.getValue(context);
		return object;
	}

	@Override
	public String formatContextToString(AopUtilContext<? extends AopUtilConfig<?>> aopContext) {
		Object object = formatContext(aopContext);
		if (object == null) {
			return null;
		} else {
			return object.toString();
		}
	}

}
