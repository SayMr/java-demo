package com.zyt.javademo.provider.bean;

import com.zyt.api.context.ReMessage;

/**
 * Created by zhuyintao.
 * Date: 2018/9/20
 */
public class SuccessResult<T> extends AbstractResult<T> {
    public SuccessResult(ReMessage error, T dataT) {
        super(error, dataT);
    }

    public SuccessResult(ReMessage error) {
        super(error, null);
    }
}
