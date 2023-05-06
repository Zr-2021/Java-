package concurrency;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zr
 * @date 2023/4/24
 */

public class threadState {
    static final Object LOCK = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            synchronized (LOCK){
                System.out.println("before timed_waiting");
                try {
                    LOCK.wait(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end");
            }
        }, "t1");
        t1.start();
        System.out.println(t1.getState());
        synchronized (LOCK){
            System.out.println(t1.getState());
            System.out.println(t1.getState());
        }
        System.out.println(t1.getState());
    }
}
