package com.zyt.api.context;

/**
 * Created by zhuyintao.
 * Date: 2018/9/20
 */
public class Constants {
    public static final String REQUEST_ID = "zyt-header-rid";
    public static final String MDC_TRACE_ID = "zyt_traceid";
    public static final String MDC_URI = "mdc_uri";
    public static final String MDC_START_TIME = "mdc_startTime";
    public static final String MDC_IP = "mdc_ip";
    public static final String SUCCESS_MSG = "操作成功！";
    public static final Integer SUCCESS_CODE = Integer.valueOf(0);
    public static final Integer FAILURE_CODE = Integer.valueOf(1);
    public static final String FAILURE_MSG = "操作失败！";
    public static final Integer PARAMETER_ERROR_CODE = Integer.valueOf(2);
    public static final Integer UNKNOW_ERROR_CODE = Integer.valueOf(3);

    public Constants() {
    }
}
