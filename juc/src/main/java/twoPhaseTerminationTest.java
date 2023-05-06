import lombok.extern.slf4j.Slf4j;

import javax.swing.plaf.IconUIResource;

/**
 * @author zr
 * @date 2023/5/4
 */

@Slf4j(topic = "c.twoPhaseTerminationTest")
public class twoPhaseTerminationTest {
    public static void main(String[] args) throws InterruptedException {
        twoPhaseTermination tpt = new twoPhaseTermination();
        tpt.start();

        Thread.sleep(3500);
        tpt.stop();
    }
}

@Slf4j(topic = "c.twoPhaseTermination")
class twoPhaseTermination {
    private Thread monitor;

    public void start(){
        monitor = new Thread(()->{
            while (true){
                Thread currentThread = Thread.currentThread();
                if (currentThread.isInterrupted()){
                    log.debug("被打断了，处理退出...");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    log.debug("监控记录...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    currentThread.interrupt();
                }
            }
        }, "monitor");

        monitor.start();
    }

    public void stop(){
        monitor.interrupt();
    }
}
