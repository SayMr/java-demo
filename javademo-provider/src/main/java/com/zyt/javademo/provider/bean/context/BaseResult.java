package com.zyt.javademo.provider.bean.context;

import com.zyt.api.context.Constants;
import com.zyt.api.context.ReMessage;
import com.zyt.api.context.Result;

/**
 * Created by zhuyintao.
 * Date: 2018/9/20
 */
public class BaseResult {
    public BaseResult() {
    }

    public static Result success() {
        return new AbstractResult.SuccessResult(new ReMessage(Constants.SUCCESS_CODE, "操作成功！"), "");
    }

    public static <T> Result<T> success(Integer returnCode, String returnMessage) {
        return new AbstractResult.SuccessResult(new ReMessage(returnCode, returnMessage), "");
    }

    public static <T> Result success(Integer returnCode, String returnMessage, T dataT) {
        return new AbstractResult.SuccessResult(new ReMessage(returnCode, returnMessage), dataT);
    }

    public static <T> Result success(T dataT) {
        return new AbstractResult.SuccessResult(new ReMessage(Constants.SUCCESS_CODE, "操作成功！"), dataT);
    }

    public static Result failure() {
        return new FailureResult(new ReMessage(Constants.FAILURE_CODE, "操作失败！"));
    }

    public static Result failure(String errorMessage) {
        return new FailureResult(new ReMessage(Constants.FAILURE_CODE, errorMessage));
    }

    public static Result failure(Integer returnCode, String returnMessage) {
        return new FailureResult(new ReMessage(returnCode, returnMessage));
    }

    public static <T> Result failure(Integer returnCode, String returnMessage, T dataT) {
        return new FailureResult(new ReMessage(returnCode, returnMessage), dataT);
    }
}
