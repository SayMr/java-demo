package com.zyt.javademo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuyintao.
 * Date: 2018/10/9
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
