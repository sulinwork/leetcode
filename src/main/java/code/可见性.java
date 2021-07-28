package code;

public class 可见性 {
    private static boolean initFlag = false;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (!initFlag) {

            }
            System.out.println("线程A结束");
        }).start();
        Thread.sleep(2 * 1000);
        new Thread(() -> {
            System.out.println("修改initFlag的值");
            initFlag = true;
            System.out.println("修改完成");
        }).start();
    }
}
