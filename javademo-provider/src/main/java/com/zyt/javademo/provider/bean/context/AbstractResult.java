package com.zyt.javademo.provider.bean.context;

import com.zyt.javademo.api.context.ReMessage;
import com.zyt.javademo.api.context.Result;

/**
 * Created by zhuyintao.
 * Date: 2018/9/20
 */
public class AbstractResult<T> implements Result<T> {
    private static final long serialVersionUID = 1L;
    protected ReMessage error;
    protected T data;
    protected String logId;

    public AbstractResult(ReMessage error, T dataT) {
        this.error = error;
        this.data = dataT;
        //this.logId = MDC.get("jdb_traceid");
    }

    public AbstractResult() {
    }

    @Override
    public ReMessage getError() {
        return this.error;
    }

    @Override
    public void setError(ReMessage error) {
        this.error = error;
    }

    @Override
    public T getData() {
        return this.data;
    }

    @Override
    public void setData(T dataT) {
        this.data = dataT;
    }

    @Override
    public String getLogId() {
        return this.logId;
    }

    @Override
    public void setLogId(String logId) {
        this.logId = logId;
    }

    /**
     * Created by zhuyintao.
     * Date: 2018/9/20
     */
    public static class SuccessResult<T> extends AbstractResult<T> {
        public SuccessResult(ReMessage error, T dataT) {
            super(error, dataT);
        }

        public SuccessResult(ReMessage error) {
            super(error, null);
        }
    }
}