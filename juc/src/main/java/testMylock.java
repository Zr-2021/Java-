import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

/**
 * @author zr
 * @date 2023/5/6
 */

@Slf4j(topic = "c.testMylock")
public class testMylock {
    public static void main(String[] args) {
        Mylock lock = new Mylock();
        new Thread(() -> {
            lock.lock();
            try {
                log.debug("get lock...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log.debug("release lock...");
                lock.unlock();
            }
        }, "t1").start();
        new Thread(() -> {
            lock.lock();
            try {
                log.debug("get lock...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log.debug("release lock...");
                lock.unlock();
            }
        }, "t2").start();
    }
}
