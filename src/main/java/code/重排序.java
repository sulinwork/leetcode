package code;

import java.util.HashSet;
import java.util.Set;

public class 重排序 {
    static int x, y, a, b;

    public static void main(String[] args) throws InterruptedException {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 10000000; i++) {
            x = y = a = b = 0;
            Thread thread1 = new Thread(() -> {
                a = y;
                x = 1;
            });
            Thread thread2 = new Thread(() -> {
                b = x;
                y = 1;
            });
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            set.add("a=" + a + "," + "b=" + b);
            System.out.println(set);
        }
        System.out.println("最终结果:"+set);
    }
}
