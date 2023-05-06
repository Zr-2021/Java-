import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author zr
 * @date 2023/5/4
 */

@Slf4j(topic = "c.futureTaskTest")
public class futureTaskTest {
    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("running...");
                Thread.sleep(1000);
                return 100;
            }
        });

        Thread t1 = new Thread(task, "t1");
        t1.start();

        log.debug("running...");
    }
}
