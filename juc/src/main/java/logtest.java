import lombok.extern.slf4j.Slf4j;

/**
 * @author zr
 * @date 2023/5/4
 */

@Slf4j(topic = "c.test")
public class logtest {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                log.debug("running");
            }
        };

//        t1.setName("t1");
        t1.start();
        log.debug("running");
    }
}
