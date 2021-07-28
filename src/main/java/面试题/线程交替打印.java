package 面试题;

import java.util.concurrent.locks.LockSupport;

public class 线程交替打印 {
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        function1();
    }

    public static void function1() {
        String[] arr1 = new String[]{"1", "2", "3", "4", "5"};
        String[] arr2 = new String[]{"A", "B", "C", "D", "E"};


        t1 = new Thread(() -> {
            for (String arr : arr1) {
                System.out.println(arr);
                LockSupport.unpark(t2);
                LockSupport.park();

            }
        });
        t2 = new Thread(() -> {
            for (String arr : arr2) {
                System.out.println(arr);
                LockSupport.unpark(t1);
                LockSupport.park();
            }
        });
        t1.start();
        t2.start();
    }
}
