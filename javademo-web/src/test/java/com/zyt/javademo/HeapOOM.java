package com.zyt.javademo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuyintao.
 * Date: 2018/10/9
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while(true) {
            list.add(new OOMObject());
        }
    }
}
