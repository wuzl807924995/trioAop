//package test.demo.validation;
//
//import io.github.zh.cn.trio.aop.function.validation.context.ValidationBeanContext;
//import io.github.zh.cn.trio.aop.function.validation.face.AbstractErrorRetrunValidation;
//import io.github.zh.cn.trio.aop.function.validation.result.IReturnResult;
//import test.demo.face.bean.User;
//
//public class ErrorValidation extends AbstractErrorRetrunValidation {
//
//	@Override
//	public <T> IReturnResult<T> validation(ValidationBeanContext context) {
//		return new IReturnResult<T>() {
//
//			@Override
//			public boolean isSuccess() {
//				return true;
//			}
//
//			@SuppressWarnings("unchecked")
//			@Override
//			public T getErrorResult() {
//				User user = new User();
//				user.setId(1001);
//				return (T) user;
//			}
//		};
//	}
//
//}
