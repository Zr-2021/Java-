import lombok.extern.slf4j.Slf4j;

/**
 * @author zr
 * @date 2023/5/4
 */

@Slf4j(topic = "c.runnableTest")
public class runnableTest {
    public static void main(String[] args) {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                log.debug("runnable");
//            }
//        };
        Runnable runnable = () -> log.debug("runnable");

        Thread t1 = new Thread(runnable,"t1");
        t1.start();
        log.debug("runnable");
    }
}
