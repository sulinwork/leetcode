package code;

public class WriteThead implements Runnable {

    private Sync sync;

    public WriteThead(Sync sync) {
        this.sync = sync;
    }

    @Override
    public void run() {

    }

    //
//    @Override
//    public void run() {
//        while (true) {
//            sync.count--;
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (sync.count < 0) break;
//        }
//    }
}
