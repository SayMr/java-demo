package com.zyt.javademo.web.interceptor;

import com.zyt.api.context.Constants;
import com.zyt.api.context.ServiceException;
import com.zyt.javademo.provider.bean.context.BaseResult;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;


/**
 * Created by zhuyintao.
 * Date: 2018/9/23
 */
public class CustomExceptionHandler implements MethodInterceptor {
    private static final Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);

    public CustomExceptionHandler() {
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object object = null;

        try {
            object = methodInvocation.proceed();
        } catch (Exception var4) {
            if (var4 instanceof ServiceException) {
                log.error("Service Exception!", var4);
                return BaseResult.failure(((ServiceException)var4).getErrorCode(), var4.getMessage());
            }

            if (!(var4 instanceof IllegalArgumentException) && !(var4 instanceof BindException)) {
                object = BaseResult.failure(Constants.UNKNOW_ERROR_CODE, "操作失败！");
            } else {
                object = BaseResult.failure(Constants.PARAMETER_ERROR_CODE, "操作失败！");
            }

            log.error("CustomExceptionHandler process occurs exception", var4);
        }

        log.info(object+"");
        return object;
    }
}
