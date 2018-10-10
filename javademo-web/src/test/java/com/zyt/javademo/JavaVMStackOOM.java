package com.zyt.javademo;

/**
 * Created by zhuyintao.
 * Date: 2018/10/9
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while(true) {

        }
    }

    public void stackLeakByTread() {
        while(true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByTread();
    }
}
