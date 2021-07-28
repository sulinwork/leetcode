package code;

import org.openjdk.jol.info.ClassLayout;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.concurrent.TimeUnit;


public class ArrayListDemo {
    public static void main(String[] args) throws InterruptedException {
//        Object after = new Object();
//        System.out.println(ClassLayout.parseInstance(after).toPrintable());
//        synchronized (after) {
//            System.out.println(ClassLayout.parseInstance(after).toPrintable());
//        }
//        System.out.println(ClassLayout.parseInstance(after).toPrintable());

        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        Long dayTime5 = localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        System.out.println(dayTime5);
    }

}
