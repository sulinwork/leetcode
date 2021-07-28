import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.ftp.Ftp;
import cn.hutool.extra.ftp.FtpMode;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;


public class Demo {

    public static void main(String[] args) throws IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        System.out.println(threadLocal);
        threadLocal.set("demo");
        //断开强引用
        threadLocal = null;
        System.gc();
        //等待弱引用被gc
        Thread.sleep(5000);
        Thread thread = Thread.currentThread();
//        Field threadLocals = thread.getClass().getDeclaredField("threadLocals");
//        threadLocals.setAccessible(true);
//        Object o = threadLocals.get(thread);
        System.out.println("==============");
    }
}
