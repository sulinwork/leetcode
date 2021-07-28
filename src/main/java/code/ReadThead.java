package code;

public class ReadThead extends Thread {

    private Sync sync;

    public ReadThead(Sync sync) {
        this.sync = sync;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sync.flag = true;
        System.out.println("flag:" + sync.flag);
    }
}
