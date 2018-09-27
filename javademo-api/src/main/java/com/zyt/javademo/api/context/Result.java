package com.zyt.javademo.api.context;

import java.io.Serializable;

public interface Result<T> extends Serializable {
    T getData();

    void setData(T var1);

    ReMessage getError();

    void setError(ReMessage var1);

    String getLogId();

    void setLogId(String var1);
}