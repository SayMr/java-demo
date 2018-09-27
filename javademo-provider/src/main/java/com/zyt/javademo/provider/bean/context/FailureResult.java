package com.zyt.javademo.provider.bean.context;

import com.zyt.api.context.ReMessage;
import com.zyt.javademo.provider.bean.context.AbstractResult;

/**
 * Created by zhuyintao.
 * Date: 2018/9/20
 */
public class FailureResult<T> extends AbstractResult<T> {
    public FailureResult(ReMessage error, T dataT) {
        super(error, dataT);
    }

    public FailureResult(ReMessage error) {
        super(error, null);
    }
}
